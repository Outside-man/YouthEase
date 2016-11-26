package org.apache.jsp.WEB_002dINF.views.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\n");
      out.write("    \n");
      out.write("    <title>College Art | Home</title>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("  <link rel=\"icon\" href=\"http://dzyngiri.com/favicon.png\" type=\"image/x-icon\">\n");
      out.write("    <link rel=\"shortcut icon\" href=\"http://dzyngiri.com/favicon.png\" type=\"image/x-icon\" />\n");
      out.write("    <meta name=\"description\" content=\"Codester is a free responsive Bootstrap template by Dzyngiri\">\n");
      out.write("    <meta name=\"keywords\" content=\"free, template, bootstrap, responsive\">\n");
      out.write("    <meta name=\"author\" content=\"Inbetwin Networks\">  \n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/bootstrap.css\" type=\"text/css\" media=\"screen\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/responsive.css\" type=\"text/css\" media=\"screen\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" media=\"screen\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/touchTouch.css\" type=\"text/css\" media=\"screen\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/kwicks-slider.css\" type=\"text/css\" media=\"screen\">\n");
      out.write("\t<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"js/superfish.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.flexslider-min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.kwicks-1.5.1.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.easing.1.3.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.cookie.js\"></script>    \n");
      out.write("\t<script type=\"text/javascript\" src=\"js/touchTouch.jquery.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\">if($(window).width()>1024){document.write(\"<\"+\"script src='js/jquery.preloader.js'></\"+\"script>\");} </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  <script>    \n");
      out.write("     jQuery(window).load(function() { \n");
      out.write("     $x = $(window).width();    \n");
      out.write("  if($x > 1024)\n");
      out.write("  {     \n");
      out.write("  jQuery(\"#content .row\").preloader();    } \n");
      out.write("     \n");
      out.write("     jQuery('.magnifier').touchTouch();     \n");
      out.write("    jQuery('.spinner').animate({'opacity':0},1000,'easeOutCubic',function (){jQuery(this).css('display','none')});  \n");
      out.write("        }); \n");
      out.write("        \n");
      out.write("  </script>\n");
      out.write("\n");
      out.write("<!--[if lt IE 8]>\n");
      out.write("      <div style='text-align:center'><a href=\"http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode\"><img src=\"http://www.theie6countdown.com/img/upgrade.jpg\"border=\"0\"alt=\"\"/></a></div>  \n");
      out.write("  <![endif]-->\n");
      out.write("  <!--[if (gt IE 9)|!(IE)]><!-->\n");
      out.write("  <!--<![endif]-->\n");
      out.write("  <!--[if lt IE 9]>\n");
      out.write("    <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/docs.css\" type=\"text/css\" media=\"screen\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/ie.css\" type=\"text/css\" media=\"screen\">\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400' rel='stylesheet' type='text/css'>\n");
      out.write("  <![endif]-->\n");
      out.write("\n");
      out.write("  </head>\n");
      out.write("  \n");
      out.write("  <body>\n");
      out.write("   <div class=\"backtotop\"><a href=\"#top\"><img src=\"img/backToTop.png\"></a></div>\n");
      out.write("    <div class=\"spinner\"></div> \n");
      out.write("    \n");
      out.write("<!-- header start -->\n");
      out.write("<header>\n");
      out.write("      <div class=\"container clearfix\" id=“top”>\n");
      out.write("    <div class=\"row\">\n");
      out.write("          <div class=\"span12\">\n");
      out.write("        <div class=\"navbar navbar_\">\n");
      out.write("              <div class=\"container\">\n");
      out.write("            <h1 class=\"brand brand_\"><a href=\"index.jsp\"><img alt=\"\" src=\"img/logo.png\"> </a></h1>\n");
      out.write("            <a class=\"btn btn-navbar btn-navbar_\" data-toggle=\"collapse\" data-target=\".nav-collapse_\">Menu <span class=\"icon-bar\"></span> </a>\n");
      out.write("            <div class=\"nav-collapse nav-collapse_  collapse\">\n");
      out.write("                  <ul class=\"nav sf-menu\">\n");
      out.write("                <li class=\"active\"><a href=\"index.jsp\">首页</a></li>\n");
      out.write("                <li class=\"sub-menu\"><a href=\"#\">帖子汇总&nbsp;</a> \n");
      out.write("                      <ul>\n");
      out.write("                    <li><a href=\"/redirect/emotion\">感情帖</a></li>\n");
      out.write("                <li><a href=\"/redirect/trade\">交易帖</a></li>\n");
      out.write("                <li><a href=\"/redirect/mix\">杂&nbsp;帖</a></li>\n");
      out.write("                  </ul>\n");
      out.write("                    </li>\n");
      out.write("                <li><a href=\"work.jsp\">作品栈</a></li>\n");
      out.write("                      ");
 if(request.getSession().getAttribute("user")==null) {

                      
      out.write("\n");
      out.write("                <li class=\"sub-menu\"><a href=\"/redirect/login\">登&nbsp;录</a>\n");
      out.write("                      <ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <li><a href=\"/redirect/register\">注册</a></li> </ul>\n");
      out.write("                    ");
}else{
      out.write("\n");
      out.write("                          <li><a href=\"user/logout\">登出</a></li>\n");
      out.write("                          ");
}
      out.write("\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                <li><a href=\"/redirect/contact\">联系我们</a></li>\n");
      out.write("                <li><h3><a href=\"/redirect/locate\">杭州</a></h3></li>\n");
      out.write("              </ul>\n");
      out.write("                </div>\n");
      out.write("          </div>\n");
      out.write("            </div>\n");
      out.write("      </div>\n");
      out.write("        </div>\n");
      out.write("  </div>\n");
      out.write("    </header>\n");
      out.write("<div class=\"bg-content\">\n");
      out.write("     <div class=\"container\" id=\"container\" >\n");
      out.write("    <div class=\"row\">\n");
      out.write("          <div class=\"span12\"> \n");
      out.write("        <!-- slider -->\n");
      out.write("        <div class=\"flexslider\">\n");
      out.write("              <ul class=\"slides\">\n");
      out.write("            <li> <img src=\"img/slide-1.jpg\" alt=\"\" > </li>\n");
      out.write("            <li> <img src=\"img/slide-2.jpg\" alt=\"\" > </li>\n");
      out.write("            <li> <img src=\"img/slide-3.jpg\" alt=\"\" > </li>\n");
      out.write("            <li> <img src=\"img/slide-4.jpg\" alt=\"\" > </li>\n");
      out.write("            <li> <img src=\"img/slide-5.jpg\" alt=\"\" > </li>\n");
      out.write("          </ul>\n");
      out.write("            </div>\n");
      out.write("        <span id=\"responsiveFlag\"></span>\n");
      out.write("        <div class=\"block-slogan\">\n");
      out.write("              <h2>Trade!</h2>\n");
      out.write("              <div>\n");
      out.write("            <p>新一代大学生论坛，专为大学生打造的信息发布平台，发帖的同时让更多人知道你的作品、经历、心情以及进行各种交易，娱乐交友两不误。快来发帖交易吧！</p>\n");
      out.write("            <p style=\"text-align:center; padding-top:20px;\"><a href=\"#\" class=\"btn btn-1\">我要发帖</a></p>\n");
      out.write("          </div>\n");
      out.write("            </div>\n");
      out.write("      </div>\n");
      out.write("        </div>\n");
      out.write("  </div>\n");
      out.write("      \n");
      out.write("      <!-- content -->\n");
      out.write("      \n");
      out.write("      <div id=\"content\" class=\"content-extra\"><div class=\"ic\"></div>\n");
      out.write("    <div class=\"row-1\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("        <article class=\"span12\">\n");
      out.write("        <h4>帖子精选</h4>\n");
      out.write("         </article>\n");
      out.write("              <ul class=\"thumbnails thumbnails-1\">\n");
      out.write("            <li class=\"span3\">\n");
      out.write("                  <div class=\"thumbnail thumbnail-1\">\n");
      out.write("                <h3>焚烧坏情绪</h3>\n");
      out.write("                <img  src=\"img/blog-featured-01.jpg\" alt=\"\">\n");
      out.write("                <section> \n");
      out.write("                    <a href=\"#\"><h3>At vero eos et accusamus et iusto </h3></a>\n");
      out.write("                      <div class=\"meta\">\n");
      out.write("                            <time datetime=\"2012-11-09\" class=\"date-1\"><i class=\"icon-calendar\"></i> 9.11.2012</time>\n");
      out.write("                            <div class=\"name-author\"><i class=\"icon-user\"></i> <a href=\"#\">Admin</a></div>\n");
      out.write("                            <a href=\"#\" class=\"comments\"><i class=\"icon-comment\"></i> 7 comments</a>\n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"clear\"></div>\n");
      out.write("                      <p>Vivamus sollicitudin libero auctor arcu pulvinar commodo.</p>\n");
      out.write("                      <a href=\"#\" class=\"btn btn-1\">Read More</a> </section>\n");
      out.write("              </div>\n");
      out.write("                </li>\n");
      out.write("            <li class=\"span3\">\n");
      out.write("                  <div class=\"thumbnail thumbnail-1\">\n");
      out.write("                <h3>平面设计</h3>\n");
      out.write("                <img  src=\"img/blog-featured-02.jpg\" alt=\"\">\n");
      out.write("                <section> \n");
      out.write("                    <a href=\"#\"><h3>Deleniti atque corrupti quos</h3></a>\n");
      out.write("                        <div class=\"meta\">\n");
      out.write("                            <time datetime=\"2012-11-09\" class=\"date-1\"><i class=\"icon-calendar\"></i> 9.11.2012</time>\n");
      out.write("                            <div class=\"name-author\"><i class=\"icon-user\"></i> <a href=\"#\">Admin</a></div>\n");
      out.write("                            <a href=\"#\" class=\"comments\"><i class=\"icon-comment\"></i> 4 comments</a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"clear\"></div>            \n");
      out.write("                      <p>Vestibulum volutpat urna sed sapien vehicula varius.</p>\n");
      out.write("                      <a href=\"#\" class=\"btn btn-1\">Read More</a> </section>\n");
      out.write("              </div>\n");
      out.write("                </li>\n");
      out.write("            <li class=\"span3\">\n");
      out.write("                  <div class=\"thumbnail thumbnail-1\">\n");
      out.write("                <h3>摄影</h3>\n");
      out.write("                <img  src=\"img/blog-featured-03.jpg\" alt=\"\">\n");
      out.write("                <section>\n");
      out.write("                    <a href=\"#\"><h3>Similique sunt in culpa qui officia</h3></a>\n");
      out.write("                        <div class=\"meta\">\n");
      out.write("                            <time datetime=\"2012-11-09\" class=\"date-1\"><i class=\"icon-calendar\"></i> 9.11.2012</time>\n");
      out.write("                            <div class=\"name-author\"><i class=\"icon-user\"></i> <a href=\"#\">Admin</a></div>\n");
      out.write("                            <a href=\"#\" class=\"comments\"><i class=\"icon-comment\"></i> 9 comments</a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"clear\"></div>   \n");
      out.write("                      <p>Pellentesque mi justo, laoreet non bibendum non, auctor imperdiet eros.</p>\n");
      out.write("                      <a href=\"#\" class=\"btn btn-1\">Read More</a> </section>\n");
      out.write("              </div>\n");
      out.write("                </li>\n");
      out.write("            <li class=\"span3\">\n");
      out.write("                  <div class=\"thumbnail thumbnail-1\">\n");
      out.write("                <h3 class=\"title-1 extra\">后期</h3>\n");
      out.write("                <img  src=\"img/blog-featured-04.jpg\" alt=\"\">\n");
      out.write("                <section> <a href=\"#\"><h3>Similique sunt in culpa qui officia</h3></a>\n");
      out.write("                    <div class=\"meta\">\n");
      out.write("                            <time datetime=\"2012-11-09\" class=\"date-1\"><i class=\"icon-calendar\"></i> 9.11.2012</time>\n");
      out.write("                            <div class=\"name-author\"><i class=\"icon-user\"></i> <a href=\"#\">Admin</a></div>\n");
      out.write("                            <a href=\"#\" class=\"comments\"><i class=\"icon-comment\"></i> 1 comment</a>\n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"clear\"></div>   \n");
      out.write("                      <p>Vestibulum volutpat urna sed sapien vehicula varius.</p>\n");
      out.write("                      <a href=\"#\" class=\"btn btn-1\">Read More</a> </section>\n");
      out.write("              </div>\n");
      out.write("                </li>\n");
      out.write("          </ul>\n");
      out.write("            </div>\n");
      out.write("      </div>\n");
      out.write("        </div>\n");
      out.write("    <div class=\"row-2\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("        \t<h3>部分慷慨的人士捐献的开源作品</h3>\n");
      out.write("            <h3>容易使用，免费下载，有爱的！</h3>\n");
      out.write("            <p>这个平台是完全提供给新手借鉴学习的。</p>\n");
      out.write("            <a href=\"work.jsp\" class=\"btn btn-1\">进入下载</a>\n");
      out.write("      </div>\n");
      out.write("        </div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <div class=\"container\">\n");
      out.write("          <div class=\"row\">\n");
      out.write("        <article class=\"span6\">\n");
      out.write("              <h3>关于我们</h3>\n");
      out.write("              <div class=\"wrapper\">\n");
      out.write("            <figure class=\"img-indent\"><img src=\"img/15.jpg \" alt=\"\" /></figure>\n");
      out.write("            <div class=\"inner-1 overflow extra\">\n");
      out.write("                  <div class=\"txt-1\">平台提供者，杭州电子科学大学信息工程学院三人组</div>\n");
      out.write("                  你可以非常方便地找到我们，联系我们<a href=\"#\">xingong@163.com</a>\n");
      out.write("                </div>\n");
      out.write("          </div>\n");
      out.write("            </article>\n");
      out.write("        <article class=\"span6\">\n");
      out.write("              <h3>站外链接</h3>\n");
      out.write("                <div class=\"wrapper\">\n");
      out.write("                    <ul class=\"list list-pad\">\n");
      out.write("                          <li><a href=\"#\">Campaigns</a></li>\n");
      out.write("                          <li><a href=\"#\">Portraits</a></li>\n");
      out.write("                          <li><a href=\"#\">Fashion</a></li>\n");
      out.write("                          <li><a href=\"#\">Fine Art</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    <ul class=\"list list-pad\">\n");
      out.write("                          <li><a href=\"#\">Campaigns</a></li>\n");
      out.write("                          <li><a href=\"#\">Portraits</a></li>\n");
      out.write("                          <li><a href=\"#\">Fashion</a></li>\n");
      out.write("                          <li><a href=\"#\">Fine Art</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    <ul class=\"list\">\n");
      out.write("                          <li><a href=\"#\">Advertising</a></li>\n");
      out.write("                          <li><a href=\"#\">Lifestyle</a></li>\n");
      out.write("                          <li><a href=\"#\">Love story</a></li>\n");
      out.write("                          <li><a href=\"#\">Landscapes</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </article>\n");
      out.write("      </div>\n");
      out.write("        </div>\n");
      out.write("  </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("  \n");
      out.write("<!-- footer -->\n");
      out.write("<footer>\n");
      out.write("      <div class=\"container clearfix\">\n");
      out.write("    <ul class=\"list-social pull-right\">\n");
      out.write("          <li><a class=\"icon-1\" href=\"#\"></a></li>\n");
      out.write("          <li><a class=\"icon-2\" href=\"#\"></a></li>\n");
      out.write("          <li><a class=\"icon-3\" href=\"#\"></a></li>\n");
      out.write("          <li><a class=\"icon-4\" href=\"#\"></a></li>\n");
      out.write("        </ul>\n");
      out.write("    <div class=\"privacy pull-left\">&copy; Copyright &copy; 2016.College Art  All rights reserved.<a target=\"_blank\" href=\"http://sc.chinaz.com/moban/\"></a></div>\n");
      out.write("  </div>\n");
      out.write("    </footer>\n");
      out.write("<script type=\"text/javascript\" src=\"js/bootstrap.js\"></script>\n");
      out.write("<div style=\"display:none\"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>\n");
      out.write("  </body>\n");
      out.write("</jsp>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
