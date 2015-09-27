<%-- 
    Document   : indexJSP
    Created on : 25/09/2015, 16:06:35
    Author     : prisley.costa
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tela Inicial Fórum</title>
        <style type="text/css">

        html, body, h1, form, fieldset {
          margin: 0;
          padding: 0;
          border: none;
          }

        body { font-family: Helvetica, Arial, sans-serif; font-size: 12px; }

                #formBt {
                                color: #fff;
                    background: #2d2d2d;
                    background: -webkit-gradient(
                                    linear,
                                    left bottom,
                                    left top,
                                    color-stop(0, rgb(60,60,60)),
                                    color-stop(0.74, rgb(43,43,43)),
                                    color-stop(1, rgb(60,60,60))
                                );
                    background: -moz-linear-gradient(
                                    center bottom,
                                    rgb(60,60,60) 0%,
                                    rgb(43,43,43) 74%,
                                    rgb(60,60,60) 100%
                                );
                    -moz-border-radius: 10px;
                    -webkit-border-radius: 10px;
                                border-radius: 10px;
                    margin: 10px;
                                width: 650px;
                    }

        #formBt p {
            position: relative;
        }

        #formBt fieldset {
            padding: 20px;
        }

        #formBt h2 {
            color: #fff;
            text-shadow: 0px -1px 0px #000;
            border-bottom: solid #181818 1px;
            -moz-box-shadow: 0px 1px 0px #3a3a3a;
            text-align: center;
            padding: 18px;
            margin: 0px;
            font-weight: normal;
            font-size: 24px;
            font-family: Lucida Grande, Helvetica, Arial, sans-serif;
        }  
        #formBt h3 {
            color: #fff;
            text-shadow: 0px -1px 0px #000;
            border-bottom: solid #181818 1px;
            -moz-box-shadow: 0px 1px 0px #3a3a3a;
            text-align: center;
            padding: 18px;
            margin: 0px;
            font-weight: normal;
            font-size: 13px;
            font-family: Lucida Grande, Helvetica, Arial, sans-serif;
        }  
        
        fieldset label.infield {
            color: #333;
            text-shadow: 0px 1px 0px #fff;
            position: absolute;
            text-align: left;
            top: 3px !important;
            left: 35px !important;
            line-height: 29px;
        }

        .botao {
            -moz-box-shadow:inset 0px 1px 0px 0px #ffffff;
            -webkit-box-shadow:inset 0px 1px 0px 0px #ffffff;
            box-shadow:inset 0px 1px 0px 0px #ffffff;
            background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ededed), color-stop(1, #dfdfdf) );
            background:-moz-linear-gradient( center top, #ededed 5%, #dfdfdf 100% );
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed', endColorstr='#dfdfdf');
            background-color:#ededed;
            -webkit-border-top-left-radius:19px;
            -moz-border-radius-topleft:19px;
            border-top-left-radius:19px;
            -webkit-border-top-right-radius:19px;
            -moz-border-radius-topright:19px;
            border-top-right-radius:19px;
            -webkit-border-bottom-right-radius:19px;
            -moz-border-radius-bottomright:19px;
            border-bottom-right-radius:19px;
            -webkit-border-bottom-left-radius:19px;
            -moz-border-radius-bottomleft:19px;
            border-bottom-left-radius:19px;
            text-indent:-4.27px;
            border:1px solid #dcdcdc;
            display:inline-block;
            color:#777777;
            font-family:Arial;
            font-size:13px;
            font-weight:bold;
            font-style:normal;
            height:22px;
            line-height:22px;
            width:62px;
            text-decoration:none;
            text-align:center;
            text-shadow:1px 1px 0px #ffffff;
        }
        .botao{
                background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #dfdfdf), color-stop(1, #ededed) );
                background:-moz-linear-gradient( center top, #dfdfdf 5%, #ededed 100% );
                filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#dfdfdf', endColorstr='#ededed');
                background-color:#dfdfdf;
        }.botao:active {
                position:relative;
                top:1px;
        }

        </style>
    </head>
    <body>
        <div id="formBt">
            <h2>Tela Inicial Fórum</h2>
            <meta http-equiv="refresh" content="5;URL=index">
            <form action="" method="POST">
                <fieldset>
                    <c:choose>
                        <c:when test="${not empty usuario}">
                            <h3>Olá <c:out value="${usuario.nomeLogin}"/></h3>
                            <div id="divAssuntos">
                                <!-- falta mostrar os assuntos na tela!!!!!! -->
                                <table border="1" style="width:100%">
                                    <tr>
                                        <td>Assunto</td>
                                        <td>Quantidade Tópicos</td>
                                        <!--<td>Quantidade Mensagens</td>-->
                                        <td>Usuário</td>
                                        <td>Data Última Postagem</td>
                                    </tr>
                                        <c:forEach var="assunto" items="${assuntos}">
                                    <tr>
                                        <td><a href=${assunto.id}> ${assunto.assunto}  </a></td><br />
                                        <td>${topicos.size}</td>
                                        <!--<td>$</td>-->
                                        <td>${autor.nomeLogin}</td>
                                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${topico.dataCriacao}" /></td>
                                    </tr>
                                        </c:forEach>
                                </table>
                                <br>
                            </div>
                            <a href="CadastroAssunto" class="botao">Novo</a>
                            <a href="Logoff" class="botao">Logoff</a>
                        </c:when>
                        <c:otherwise>
                            <a href="LoginUser" class="botao">Login</a>
                            <a href="CadastroUser" class="botao">Cadastro</a>
                        </c:otherwise>
                    </c:choose>
                </fieldset>
            </form>
        </div>
    </body>
</html>