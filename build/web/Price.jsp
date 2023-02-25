<%@page import="Util.Calc"%>
<%@page import="Util.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.text.DecimalFormat"%>

<%!
    double montante, juros, total, auxP, auxA, auxJuros, auxSaldo, auxJurosTotal;
    int parcelas;

    DecimalFormat df = new DecimalFormat("###,##0.00");
%>

<%  // validação de usuário e registro na sessão
    boolean logado = true;
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
%>


<!--HTML-->
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" href="style/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela Price</title>
    </head>
    <body>
        <%
            boolean primeiravez = false;
            try {
                //verificar valores
                montante = Double.parseDouble(request.getParameter("montante"));
                juros = Double.parseDouble(request.getParameter("juros"));
                parcelas = Integer.parseInt(request.getParameter("parc"));

            } catch (Exception e) {
                primeiravez = true;
            }
        %>
        <%@include file="WEB-INF/jspf/header.jspf"%>


        <div class="container">
            <%if (!primeiravez) {%>
            <br><br>
            <table class="table table-sm table-bordered">
                <tr>
                    <th scope="row">Valor do Empréstimo:</th>
                    <td><%=montante%></td>
                </tr>
                <tr>
                    <th scope="row">Juros do Financiamento:</th>
                    <td><%= juros%>%</td>

                </tr>
                <tr>
                    <th scope="row">Parcelas:</th>
                    <td><%= parcelas%></td>
                </tr>
            </table>
            <br><br>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Parcela</th>
                        <th scope="col">Vlr Parcela</th>
                        <th scope="col">Amortização</th>
                        <th scope="col">Juros</th>
                        <th scope="col">Sdo Devedor</th>
                    </tr>
                </thead>

                <tbody>
                    <%  Calc c = new Calc(montante, juros, parcelas);

                        for (int i = 1; i <= c.getQtd_parc(); i++) {%>
                    <tr>
                        <td>  
                           Nº<%=i%>
                        </td>
                        <td>
                            <% auxP=c.get_ValorParcela();%> 
                            <%=(df.format(auxP))%>

                        </td>
                        <td>
                            <% auxA = c.get_CalcAmortizacao();%>  
                            <%=(df.format(auxA))%>

                        </td>
                        <td>
                            <% auxJuros = c.get_CalcJuros();%> 
                            <%=(df.format(auxJuros))%>

                        </td>
                        <td>
                            <% auxSaldo = c.get_SaldoDevedor();%> 
                            <%=(df.format(auxSaldo))%>
                        </td>
                    </tr>
                    
                    <% } %>
                    
                </tbody>
                <tfoot>
                    <tr>
                        <%auxJurosTotal=c.getTotalPago();%>
                        <td>Total de Juros Pago: R$ <%=(df.format(auxJurosTotal))%>
                        <td colspan="4"></td>
                    </tr>
                </tfoot>
            </table>
            <br><br>
            <%}%>
            <h2>Gerar tabela price</h2>
            <br>
            <form action="Price.jsp">
                <div class="form-group">
                    <label for="valor">Valor do Empréstimo:</label>
                    <input class="form-control" type="number" name="montante" required />
                </div>
                <div class="form-group">
                    <label for="taxa">Juros do Financiamento:</label>
                    <input class="form-control" type="number" name="juros" required />
                </div>
                <div class="form-group">
                    <label for="parc">N° de parcelas:</label>
                    <input class="form-control" type="number"  name="parc" required />
                </div>
                <button class="btn btn-secondary btn-lg container center-align" type="submit" name="random" value="calcular">Calcular</button>
            </form>
            <br><br>
        </div>
        <div class="d-flex flex-row justify-content-center align-items-center">
            <footer>            
                <%@include file="WEB-INF/jspf/footer.jspf"%>
            </footer>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" crossorigin="anonymous"></script>

    </body>
</html>
