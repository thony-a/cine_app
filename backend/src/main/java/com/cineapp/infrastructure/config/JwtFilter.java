package com.cineapp.infrastructure.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Filtro para validar JWT en cada request
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        // rutas públicas
        if (path.contains("/auth") ||
            path.contains("/swagger-ui") ||
            path.contains("/v3/api-docs")) {

            filterChain.doFilter(request, response);
            return;
        }

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String token = header.replace("Bearer ", "");

        if (!jwtUtil.validateToken(token)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // Extraemos el username del token y lo ponemos en el contexto de seguridad
        String username = jwtUtil.extractUsername(token);

        var auth = new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                username,
                null,
                java.util.Collections.emptyList()
        );

        org.springframework.security.core.context.SecurityContextHolder
                .getContext()
                .setAuthentication(auth);

        filterChain.doFilter(request, response);
    }
}