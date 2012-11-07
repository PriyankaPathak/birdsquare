package birdsquare.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class LoginFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (isAnExcludeURL(request.getRequestURL().toString())) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        response.sendRedirect(String.format("%s/login", request.getContextPath()));
    }

    private boolean isAnExcludeURL(String requestURL) {
        List<String> excludes = Arrays.asList("login", "javascript", "css", "jpeg", "jpg", "ico");
        for (String exclude : excludes) {
            if (requestURL.contains(exclude))
                return true;
        }
        return false;
    }
}
