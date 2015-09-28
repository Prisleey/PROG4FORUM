<%-- 
    Document   : topicoJSP
    Created on : 27/09/2015, 22:12:49
    Author     : prisl
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tópicos</title>
        <style type="text/css">

        html, body, h1, form, fieldset {
          margin: 0;
          padding: 0;
          border: none;
          }

        body { font-family: Helvetica, Arial, sans-serif; font-size: 12px; }

                #formTp {
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

        #formTp p {
            position: relative;
        }

        #formTp fieldset {
            padding: 20px;
        }

        #formTp h2 {
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
        #formTp h3 {
            color: #fff;
            text-shadow: 0px -1px 0px #000;
            border-bottom: solid #181818 1px;
            -moz-box-shadow: 0px 1px 0px #3a3a3a;
            text-align: center;
            padding: 18px;
            margin: 0px;
            font-weight: normal;
            font-size: 25px;
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
            width:90px;
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
        <div id="formTp"
            <fieldset>
                <h3>Assunto: <c:out value="${assunto.assunto}"/></h3><br>
                <c:choose>
                    <c:when test="${not empty usuario}">
                        <a href="CadastroTopico?id_assunto=${assunto.id}" class="botao">Novo Tópico</a>
                    </c:when>
                </c:choose>
                <a href="index" class="botao">Voltar</a><br>
                <div id="divTopicos"><br>
                    <table border="1" style="width:100%">
                        <tr>
                            <td>Tópico</td>
                            <td>Autor</td>
                            <td>Quantidade Respostas</td>
                            <!--<td>Quantidade Acessos</td>-->
                            <!--<td>Nome Usuário Última Postagem</td>-->
                            <td>Data Última Postagem</td>
                        </tr>
                            <c:forEach var="a" items="${topicos}">
                        <tr>
                            <td><a href=Mensagem?cod_topico=${a.id}> ${a.topico}  </a></td><br />
                            <td>${topicos.autor}</td>
                            <td>${mensagens.size}</td>
                            <!--Quantidade de acessos nesse tópico
                            <td></td>-->
                            <!--Usuário que fez a última postagem
                            <td></td>-->
                            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${topico.ultimaPostagem}" /></td>
                        </tr>
                            </c:forEach>
                    </table><br>
                </div>
            </fieldset>
        </div>
    </body>
</html>