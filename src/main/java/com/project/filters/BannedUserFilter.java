package com.project.filters;

import com.project.data.UserPrincipal;
import com.project.entities.User;
import com.project.services.UserService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

@Component
public class BannedUserFilter extends OncePerRequestFilter {

    @Resource
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        HttpSession session = request.getSession();

        UserPrincipal userPrincipal = (UserPrincipal) session.getAttribute("user");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String email =((UserDetails)principal).getUsername();
            User userByEmail = userService.getUserByEmail(email);
            if (userByEmail.isBanList()) {
                session.invalidate();
                response.sendRedirect(request.getContextPath()+"/"+"ban-page");
                return;
            }
        }
        filterChain.doFilter(request, response);
    }


}