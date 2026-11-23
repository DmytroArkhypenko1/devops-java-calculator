package com.example.calculator;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
class CalculatorValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("invalidRequests")
    void shouldDisplayValidationError(
            String a,
            String b,
            String operation,
            String expectedError) throws Exception {

        MockHttpServletRequestBuilder request = post("/");

        if (a != null) {
            request.param("a", a);
        }

        if (b != null) {
            request.param("b", b);
        }

        if (operation != null) {
            request.param("operation", operation);
        }

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("error", expectedError))
                .andExpect(model().attributeDoesNotExist("result"))
                .andExpect(content().string(
                        containsString(expectedError)
                ));
    }

    static Stream<Arguments> invalidRequests() {
        String missing = "Enter both numbers.";
        String invalid = "Enter valid finite numbers.";
        String operationError = "Select a valid operation.";
        String zero = "Cannot divide by zero.";
        String overflow = "The result is outside the supported range.";

        return Stream.of(
                Arguments.of(null, "2", "add", missing),
                Arguments.of("2", null, "add", missing),
                Arguments.of("", "2", "add", missing),
                Arguments.of("2", "", "add", missing),
                Arguments.of("   ", "2", "add", missing),
                Arguments.of("2", "   ", "add", missing),

                Arguments.of("abc", "2", "add", invalid),
                Arguments.of("2", "abc", "add", invalid),
                Arguments.of("NaN", "2", "add", invalid),
                Arguments.of("2", "NaN", "add", invalid),
                Arguments.of("Infinity", "2", "add", invalid),
                Arguments.of("2", "-Infinity", "add", invalid),

                Arguments.of("8", "2", null, operationError),
                Arguments.of("8", "2", "unknown", operationError),

                Arguments.of("5", "0.0", "divide", zero),
                Arguments.of("5", "-0.0", "divide", zero),
                Arguments.of("0", "0", "divide", zero),

                Arguments.of(
                        "1.7976931348623157E308",
                        "1.7976931348623157E308",
                        "add",
                        overflow
                ),
                Arguments.of(
                        "-1.7976931348623157E308",
                        "1.7976931348623157E308",
                        "subtract",
                        overflow
                )
        );
    }

    @Test
    void shouldShowOnlyCurrentResultOrError() throws Exception {
        mockMvc.perform(post("/")
                        .param("a", "5")
                        .param("b", "2")
                        .param("operation", "divide"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("result", 2.5))
                .andExpect(model().attributeDoesNotExist("error"));

        mockMvc.perform(post("/")
                        .param("a", "5")
                        .param("b", "0")
                        .param("operation", "divide"))
                .andExpect(status().isOk())
                .andExpect(model().attribute(
                        "error", "Cannot divide by zero."
                ))
                .andExpect(model().attributeDoesNotExist("result"));

        mockMvc.perform(post("/")
                        .param("a", "5")
                        .param("b", "2")
                        .param("operation", "divide"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("result", 2.5))
                .andExpect(model().attributeDoesNotExist("error"));
    }

    @Test
    void shouldPreserveAndEscapeInvalidInput() throws Exception {
        String input = "<script>alert(1)</script>";

        mockMvc.perform(post("/")
                        .param("a", input)
                        .param("b", "2")
                        .param("operation", "add"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("a", input))
                .andExpect(model().attribute("b", "2"))
                .andExpect(model().attribute("operation", "add"))
                .andExpect(model().attribute(
                        "error", "Enter valid finite numbers."
                ))
                .andExpect(content().string(
                        containsString("&lt;script&gt;")
                ))
                .andExpect(content().string(
                        not(containsString(input))
                ));
    }
}