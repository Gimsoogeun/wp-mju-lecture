/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2012-10-16 08:16:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import org.apache.commons.lang3.StringUtils;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	// DB 접속을 위한 준비
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	String dbUrl = "jdbc:mysql://localhost:3306/web2012";
	String dbUser = "web";
	String dbPassword = "asdf";
	
	request.setCharacterEncoding("utf-8");

	// Request로 ID가 있는지 확인
	int id = 0;
	try {
		id = Integer.parseInt(request.getParameter("id"));
	} catch (Exception e) {}
	String userid = request.getParameter("userid");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String country = request.getParameter("country");
	String gender = request.getParameter("gender");
	String[] favorites = request.getParameterValues("favorites");
	String favoriteStr = StringUtils.join(favorites, ",");
	
	List<String> errorMsgs = new ArrayList<String>();
	int result = 0;
	
	if (userid == null || userid.trim().length() == 0) {
		errorMsgs.add("ID를 반드시 입력해주세요.");
	}
	
	if (name == null || name.trim().length() == 0) {
		errorMsgs.add("이름을 반드시 입력해주세요.");
	}
	
	if (gender == null || !(gender.equals("M") || gender.equals("F") )) {
		errorMsgs.add("성별에 적합하지 않은 값이 입력되었습니다.");
	}

	if (errorMsgs.size() == 0) {
		try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			stmt = conn.prepareStatement(
					"UPDATE users " +
					"SET  userid=?, name=?, email=?, country=?, gender=?, favorites=? " +
					"WHERE id=?"
					);
			stmt.setString(1,  userid);
			stmt.setString(2,  name);
			stmt.setString(3,  email);
			stmt.setString(4,  country);
			stmt.setString(5,  gender);
			stmt.setString(6,  favoriteStr);
			stmt.setInt(7,  id);
			
			result = stmt.executeUpdate();
			if (result != 1) {
				errorMsgs.add("변경에 실패하였습니다.");
			}
		} catch (SQLException e) {
			errorMsgs.add("SQL 에러: " + e.getMessage());
		} finally {
			// 무슨 일이 있어도 리소스를 제대로 종료
			if (rs != null) try{rs.close();} catch(SQLException e) {}
			if (stmt != null) try{stmt.close();} catch(SQLException e) {}
			if (conn != null) try{conn.close();} catch(SQLException e) {}
		}
	}

      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>회원목록</title>\r\n");
      out.write("\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"css/base.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<script src=\"js/jquery-1.8.2.min.js\"></script>\r\n");
      out.write("\t<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "share/header.jsp" + (("share/header.jsp").indexOf('?')>0? '&': '?') + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("current", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("Sign Up", request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \t<div class=\"container\">\r\n");
      out.write(" \t\t");
 if (errorMsgs.size() > 0) { 
      out.write("\r\n");
      out.write(" \t\t\t<div class=\"alert alert-error\">\r\n");
      out.write(" \t\t\t\t<h3>Errors:</h3>\r\n");
      out.write(" \t\t\t\t<ul>\r\n");
      out.write(" \t\t\t\t\t");
 for(String msg: errorMsgs) { 
      out.write("\r\n");
      out.write(" \t\t\t\t\t\t<li>");
      out.print(msg );
      out.write("</li>\r\n");
      out.write(" \t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write(" \t\t\t\t</ul>\r\n");
      out.write(" \t\t\t</div>\r\n");
      out.write("\t\t \t<div class=\"form-action\">\r\n");
      out.write("\t\t \t\t<a onclick=\"history.back();\" class=\"btn\">뒤로 돌아가기</a>\r\n");
      out.write("\t\t \t</div>\r\n");
      out.write("\t \t");
 } else if (result == 1) { 
      out.write("\r\n");
      out.write("\t \t\t<div class=\"alert alert-success\">\r\n");
      out.write("\t \t\t\t<b>");
      out.print( name );
      out.write("</b>님 정보가 수정되었습니다.\r\n");
      out.write("\t \t\t</div>\r\n");
      out.write("\t\t \t<div class=\"form-action\">\r\n");
      out.write("\t\t \t\t<a href=\"index.jsp\" class=\"btn\">목록으로</a>\r\n");
      out.write("\t\t \t</div>\r\n");
      out.write("\t \t");
}
      out.write("\r\n");
      out.write(" \t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
