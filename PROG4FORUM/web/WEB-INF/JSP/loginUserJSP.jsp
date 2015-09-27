<%-- 
    Document   : loginUserJSP
    Created on : 25/09/2015, 02:03:54
    Author     : prisl
--%>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Login Usuário</title>

    <style type="text/css">
        html, body, h1, form, fieldset, input {
            margin: 0;
            padding: 0;
            border: none;
        }

        body { font-family: Helvetica, Arial, sans-serif; font-size: 12px; }

        #formLogin {
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
            width: 430px;
        }

        #formLogin fieldset {
            padding: 20px;
        }

        input.text {
            -webkit-border-radius: 15px;
            -moz-border-radius: 15px;
            border-radius: 15px;
            border:solid 1px #444;
            font-size: 14px;
            width: 90%;
            padding: 7px 8px 7px 30px;
            -moz-box-shadow: 0px 1px 0px #777;
            -webkit-box-shadow: 0px 1px 0px #777;
            center bottom,
            rgb(225,225,225) 0%,
            rgb(215,215,215) 54%,
            rgb(173,173,173) 100%
        );

            linear,
            left bottom,
            left top,
            color-stop(0, rgb(225,225,225)),
            color-stop(0.54, rgb(215,215,215)),
            color-stop(1, rgb(173,173,173))
        );
            color:#333;
            text-shadow:0px 1px 0px #FFF;
        }	  

        input#email { 
            background-position: 4px 5px; 
            background-position: 4px 5px, 0px 0px;
        }

        input#password { 
            background-position: 4px -20px; 
            background-position: 4px -20px, 0px 0px;
        }

        input#name { 
            background-position: 4px -46px; 
            background-position: 4px -46px, 0px 0px; 
        }

        #formLogin h2 {
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

        #formLogin p {
            position: relative;
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
            width:61px;
            text-decoration:none;
            text-align:center;
            text-shadow:1px 1px 0px #ffffff;
        }
    
        .botao{
            background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #dfdfdf), color-stop(1, #ededed) );
            background:-moz-linear-gradient( center top, #dfdfdf 5%, #ededed 100% );
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#dfdfdf', endColorstr='#ededed');
            background-color:#dfdfdf;
        }
        
        .botao:active {
            position:relative;
            top:1px;
        }
    </style>
</head>
    <body>
        <div id="formLogin">
            <h2>Login de Usuário OPA</h2>

            <form action="LoginUser" method="POST">
                <fieldset>
                    <p>
                        <label for="email"><font size="4px">Email</font></label>
                        <input id="email" name="email" type="email" class="text" value="" />
                    </p>
                    <p>
                        <label for="pass"><font size="4px">Password</font></label>
                        <input id="password" name="password" class="text" type="password" />
                    </p>
                    <p>
                        <button id="btSalvar" class="botao" type="submit">Entrar</button>
                        <a href="index" class="botao">Voltar</a>
                    </p>
                </fieldset>
            </form>
        </div>
    </body>
</html>