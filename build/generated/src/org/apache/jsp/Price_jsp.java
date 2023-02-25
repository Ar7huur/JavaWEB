package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Util.Calc;
import Util.Usuario;

public final class Price_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    double montante, juros, total, auxP, auxA, auxJuros, auxSaldo;
    int parcelas;

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write('\n');
      out.write('\n');
  // validação de usuário e registro na sessão
    boolean logado = false;
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario != null) // já foi criado uma sessão
    {
        if (usuario != null && usuario.isValido()) {
            logado = true;
        }
    } else {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        if (login != null && !login.isEmpty()) {
            usuario = new Usuario(login, senha);
            if (usuario.isValido()) {
                session.setAttribute("usuario", usuario);
                logado = true;
            }
        }
    }
    if (!logado)
        response.sendRedirect(".");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--HTML-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cálculo de Parcelas de Empréstimos</title>\n");
      out.write("        <link href=\"Css/pricecss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            boolean primeiravez = false;
            try {
                //verificar valores
                montante = Double.parseDouble(request.getParameter("montante"));
                juros = Double.parseDouble(request.getParameter("juros"));
                parcelas = Integer.parseInt(request.getParameter("parc"));

            } catch (Exception e) {
                primeiravez = true;
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-dark bg-dark justify-content-between\">\n");
      out.write("            <a class=\"nav navbar-brand \">Arthur Figueirinha & José Renato Royer</a>\n");
      out.write("            <form class=\"form-inline\">\n");
      out.write("                <a class=\"btn btn-outline-success my-2 my-sm-0\" href=\"logout.jsp\">Logout</a>\n");
      out.write("            </form>\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("        <hr size=\"1\" style=\"border:1px dashed\">\n");
      out.write("        <h1>Cálculo de parcelas de empréstimos</h1>\n");
      out.write("        <hr>\n");
      out.write("        </br>\n");
      out.write("        <section>\n");
      out.write("            <form  class=\"form-group padding\"action=\"Price.jsp\">\n");
      out.write("                <p>\n");
      out.write("                    <label>Valor do Empréstimo:</label>\n");
      out.write("                    <input type=\"number\"  name=\"montante\" value=\"\">\n");
      out.write("                </p>\n");
      out.write("                <p>\n");
      out.write("                    <label>Juros do Financiamento:</label>\n");
      out.write("                    <input type=\"number\"  name=\"juros\" value=\"\">\n");
      out.write("                </p>\n");
      out.write("                <p>\n");
      out.write("                    <label>Nº de Parcelas:</label>\n");
      out.write("                    <input type=\"number\"  name=\"parc\" value=\"\">\n");
      out.write("                </p>\n");
      out.write("                <div>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\">Gerar Tabela</button>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            <hr>\n");
      out.write("            ");
if (!primeiravez) {
      out.write("\n");
      out.write("            <table border='0' class=\"padding\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>\n");
      out.write("                            Parcela\n");
      out.write("                        </th>\n");
      out.write("                        <th>\n");
      out.write("                            Vlr Parcela\n");
      out.write("                        </th>\n");
      out.write("                        <th>\n");
      out.write("                            Amortização\n");
      out.write("                        </th>\n");
      out.write("                        <th>\n");
      out.write("                            Juros\n");
      out.write("                        </th>\n");
      out.write("                        <th>\n");
      out.write("                            Sdo Devedor\n");
      out.write("                        </th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody class=\"padding\">\n");
      out.write("                    ");
  Calc c = new Calc(montante, juros, parcelas);
                        for (int i = 1; i <= c.getQtd_parcelas(); i++) {
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>  \n");
      out.write("\n");
      out.write("                            ");
      out.print(i);
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
 auxP = c.val_Parcela();
      out.write(' ');
      out.print(auxP);
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
auxA = c.amortizacao();
      out.write(' ');
      out.write(' ');
      out.print(auxA);
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
auxJuros = c.juros();
      out.write(' ');
      out.print(auxJuros);
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
 auxSaldo = c.sal_Devedor();
      out.write(' ');
      out.print(auxSaldo);
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("                <tfoot>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Total de Juros Pago: R$ ");
c.getTotal();
      out.write("</td>\n");
      out.write("                        <td colspan=\"4\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tfoot>\n");
      out.write("            </table>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
