/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-08-08 05:52:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class review_005fwrite_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1690937569754L));
    _jspx_dependants.put("jar:file:/C:/workspace_teamPJ/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/after5duck/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

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

      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("        <!DOCTYPE html>\r\n");
      out.write("        <html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("        <head>\r\n");
      out.write("            <meta charset=\"UTF-8\">\r\n");
      out.write("            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("            <title>리뷰작성</title>\r\n");
      out.write("\r\n");
      out.write("            <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/review_write.css\">\r\n");
      out.write("            <script src=\"https://kit.fontawesome.com/de9012b52d.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("            <style>\r\n");
      out.write("                @font-face {\r\n");
      out.write("                    font-family: 'Pretendard-Regular';\r\n");
      out.write("                    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');\r\n");
      out.write("                    font-weight: 400;\r\n");
      out.write("                    font-style: normal;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                /* 글꼴을 적용할 요소 선택자에 대한 스타일 지정 */\r\n");
      out.write("                body {\r\n");
      out.write("                    font-family: 'Pretendard-Regular';\r\n");
      out.write("                }\r\n");
      out.write("            </style>\r\n");
      out.write("\r\n");
      out.write("        </head>\r\n");
      out.write("\r\n");
      out.write("        <body>\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/beforeHeader.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <main>\r\n");
      out.write("                <div class=\"main_container\">\r\n");
      out.write("                    <form action=\"/after5duck/board/review_write\" method=\"post\" onsubmit=\"return reviewValidate()\">\r\n");
      out.write("\r\n");
      out.write("                        <fieldset>\r\n");
      out.write("                            <legend>\r\n");
      out.write("                                <h1>리뷰작성</h1>\r\n");
      out.write("                            </legend>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"test\">\r\n");
      out.write("                                <div class=\"main_second\">\r\n");
      out.write("                                    <div><i class=\"fa-solid fa-play\" style=\"color:rgb(237, 21, 93)\"></i></div>\r\n");
      out.write("                                    <div>애니 제목</div>\r\n");
      out.write("                                    <div class=\"inputTitle\">\r\n");
      out.write("                                        <input id=\"reviewTitle\" name=\"boardTitle\" type=\"text\" placeholder=\"제목을 입력해 주세요.\"\r\n");
      out.write("                                            value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reviewWrite.boardTitle}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"main_third\">\r\n");
      out.write("                                    <div><i class=\"fa-solid fa-play\" style=\"color:rgb(237, 21, 93)\"></i></div>\r\n");
      out.write("\r\n");
      out.write("                                    <div>별점</div>\r\n");
      out.write("\r\n");
      out.write("                                    <!-- <form action=\"/board/review_write\" class=\"mb-3\" name=\"myform\" id=\"myform\" method=\"post\"> -->\r\n");
      out.write("                                    <div id=\"stars\">\r\n");
      out.write("                                        <input type=\"radio\" name=\"reviewStar\" value=\"1\" id=\"rate1\"><label\r\n");
      out.write("                                            for=\"rate1\">★</label>\r\n");
      out.write("                                        <input type=\"radio\" name=\"reviewStar\" value=\"2\" id=\"rate2\"><label\r\n");
      out.write("                                            for=\"rate2\">★</label>\r\n");
      out.write("                                        <input type=\"radio\" name=\"reviewStar\" value=\"3\" id=\"rate3\"><label\r\n");
      out.write("                                            for=\"rate3\">★</label>\r\n");
      out.write("                                        <input type=\"radio\" name=\"reviewStar\" value=\"4\" id=\"rate4\"><label\r\n");
      out.write("                                            for=\"rate4\">★</label>\r\n");
      out.write("                                        <input type=\"radio\" name=\"reviewStar\" value=\"5\" id=\"rate5\"><label\r\n");
      out.write("                                            for=\"rate5\">★</label>\r\n");
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <!-- </form> -->\r\n");
      out.write("                                </div>\r\n");
      out.write("\r\n");
      out.write("                                <p class=\"clickStar\">별점을 클릭해주세요</p>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"main_fourth\">\r\n");
      out.write("                                    <div>\r\n");
      out.write("                                        <div class=\"insertContent\">\r\n");
      out.write("                                            <div class=\"left-content\">\r\n");
      out.write("                                                <i class=\"fa-solid fa-play\" style=\"color:rgb(237, 21, 93)\"></i>\r\n");
      out.write("                                                <div>작성란</div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"main_fifth\">\r\n");
      out.write("                                            <textarea id=\"review_content\" name=\"boardContent\"\r\n");
      out.write("                                                placeholder=\"내용을 입력해 주세요\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${reviewWrite.boardContent}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</textarea>\r\n");
      out.write("\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <br>\r\n");
      out.write("                                        <div class=\"main_sixth\">\r\n");
      out.write("\r\n");
      out.write("                                            <div><input type=\"checkbox\" id=\"review_all\"> 전체 동의하기</div> <br>\r\n");
      out.write("                                            <div><input type=\"checkbox\" name=\"review_agree\" id=\"essential\"> 작성된 리뷰는 애니버스\r\n");
      out.write("                                                홍보\r\n");
      out.write("                                                콘텐츠로\r\n");
      out.write("                                                사용될 수 있습니다.(필수) </div><br>\r\n");
      out.write("                                            <div><input type=\"checkbox\" name=\"review_agree\" id=\"check\"> 보다 나은 리뷰 서비스 제공을\r\n");
      out.write("                                                위해 개인 정보\r\n");
      out.write("                                                수집∙이용에\r\n");
      out.write("                                                동의합니다.(선택)</div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"main_last\"><button id=\"btn_review\">등 록</button></div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                        </fieldset>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <!-- 숨겨진 값(hidden) -->\r\n");
      out.write("                        <!-- 동작 구분 -->\r\n");
      out.write("                        <input type=\"hidden\" name=\"mode\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.mode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("                        <!-- 게시판 구분 -->\r\n");
      out.write("                        <input type=\"hidden\" name=\"type\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.type}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("                        <!-- 게시글 번호 -->\r\n");
      out.write("                        <input type=\"hidden\" name=\"boardNo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.boardNo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("                        <!-- 현재 페이지 -->\r\n");
      out.write("                        <input type=\"hidden\" name=\"cp\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.cp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                </div>\r\n");
      out.write("                </form>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </main>\r\n");
      out.write("            <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("            <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/review_write.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </body>\r\n");
      out.write("\r\n");
      out.write("        </html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
