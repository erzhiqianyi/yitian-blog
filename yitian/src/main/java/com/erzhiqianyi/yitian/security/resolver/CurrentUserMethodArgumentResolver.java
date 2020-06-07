package com.erzhiqianyi.yitian.security.resolver;

import com.erzhiqianyi.yitian.security.annotations.CurrentUser;
import com.erzhiqianyi.yitian.security.model.bo.CurrentLoginUser;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.web.reactive.BindingContext;
import org.springframework.web.reactive.result.method.HandlerMethodArgumentResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Log4j2
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean supportParameter =
                parameter.getParameterType().isAssignableFrom(CurrentLoginUser.class)
                        && parameter.hasParameterAnnotation(CurrentUser.class);
        return supportParameter;

    }

    @Override
    public Mono<Object> resolveArgument(MethodParameter parameter, BindingContext bindingContext,
                                        ServerWebExchange exchange) {
        Mono<Authentication> authentication = exchange.getPrincipal();
        return authentication.map(item ->
                new CurrentLoginUser(item)
        );
    }
}
