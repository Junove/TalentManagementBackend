// package com.example.talent_api.service;

// import java.io.IOException;

// import org.springframework.web.filter.OncePerRequestFilter;

// import com.backendcust.util.JWTHelper;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// public class JwtRequestFilter extends OncePerRequestFilter {

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//         String path = request.getRequestURI();
        
//         // Skip authentication for the /customers/byemail endpoint
//         if ("/customers/byemail".equals(path)) {
//             chain.doFilter(request, response);
//             return;
//         }

//         String authHeader = request.getHeader("Authorization");
//         if (authHeader != null && authHeader.startsWith("Bearer ")) {
//             String token = authHeader.substring(7);
//             if (!JWTHelper.verifyToken(token)) {
//                 response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//                 return;
//             }
//         }
//         chain.doFilter(request, response);
//     }
// }