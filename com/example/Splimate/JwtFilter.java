package com.example.Splimate;

import org.springframework.stereotype.Component;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {
    	String path = request.getServletPath();

    	if(path.equals("/users/login") ||
    			   path.equals("/users/register") ||
    			   path.equals("/groups/create") ||
    			   path.equals("/groups/getgroups") || 
    				path.equals("/groups/mygroups")||
    	  path.equals("/members/add")||
    	  path.equals("/members/getgroupmembers")||
    	  path.equals("/expense/add") ||
    	  path.equals("/expense/groups")||
    	  path.equals("/settlementcalculate") ||
    	  path.equals("/groups/count") ||
    			  path.equals("/expense/total")||
    			  path.equals("/expense/delete")||
    			   path.equals("/expense/delete")||
    			   path.equals("/members/delete")||
    			   path.equals("/expense/add")||
    			   path.equals("/groups/delete")

    	  ){
    			    filterChain.doFilter(request, response);
    			    return;
    			}
        String authHeader =
                request.getHeader("Authorization");

        if(authHeader == null ||
           !authHeader.startsWith("Bearer ")) {

            response.setStatus(401);
            return;
        }

        String token =
                authHeader.substring(7);

        if(!jwtUtil.validateToken(token)) {

            response.setStatus(401);
            return;
        }

        filterChain.doFilter(
                request,
                response);
    }
}