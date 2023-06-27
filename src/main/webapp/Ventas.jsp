<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:include page="arriba.jsp"/>
<body class="contact-page">
    <div class="main-body">
        <div class="container">
            <div class="row">

                <div class="main-page">
                    <jsp:include page="menu.jsp"/>                    
                    <div class="content-main contact-content">                        
                        <div class="contact-content-upper">
                            <div class="row">
                                <jsp:include page="menucito.jsp"/>
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                    <div class="gallery_title">
                                        <h3>VENTAS</h3>
                                        <h4>REGISTRE</h4>
                                    </div>    
                                </div>                            
                            </div>

                            <div class="row">                                                                  
                                <div class="col-sm-12 col-md-6 contact_left">                                            
                                    <form class="form-horizontal" method="post" action="VentaControlador">

                                        <div class="form-group">                                    
                                            <input type="hidden" class="form-control" id="name" name="id" placeholder="CI..." value="${venta.cod_ventas}">
                                            <select name="id_empleado" class="form-control">
                                                <option value="">--Seleccione un Empleado--</option>
                                                <c:forEach var="item" items="${lista_empleados}">
                                                    <option value="${item.cod_empleado}"
                                                            <c:if test="${venta.id_empleado==item.cod_empleado}">
                                                        selected
                                                        </c:if>
                                                        >${item.nombres}</option>
                                                </c:forEach> 
                                            </select>
                                        </div>
                                        <div class="form-group">                                    
                                            <select name="id_cliente" class="form-control">
                                                <option value="">--Seleccione un cliente--</option>
                                                <c:forEach var="item" items="${lista_clientes}">
                                                    <option value="${item.cod_cliente}"
                                                            <c:if test="${venta.id_cliente==item.cod_cliente}">
                                                        selected
                                                        </c:if>
                                                        >${item.nombres}</option>
                                                </c:forEach> 
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <select name="id_moto" class="form-control">
                                                <option value="">--SELECCIONE UNA MOTOCICLETA--</option>
                                                <c:forEach var="item" items="${lista_motocicletas}">
                                                    <option value="${item.cod_moto}"
                                                            <c:if test="${venta.id_moto==item.cod_moto}">
                                                        selected
                                                        </c:if>
                                                        >${item.descripcion}</option>
                                                </c:forEach> 
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <input type="text" class="form-control" id="subject" name="fecha" placeholder="FECHA..." value="${venta.fecha}">        
                                        </div>
                                        <div class="form-group">
                                            <input type="number" class="form-control" id="subject" name="total" placeholder="TOTAL..." value="${venta.total}">        
                                        </div>


                                        <div class="form-group">
                                            <input id="submit" name="submit" type="submit" value="ENVIAR" class="btn view_more btn-submit">
                                        </div>            

                                    </form>    
                                </div> <!-- .contact-left -->

                                <jsp:include page="Contactenos.jsp"/>
                            </div> <!-- .row -->
                        </div>

                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div id="google-map"></div>
                            </div>                            
                        </div>

                    </div> <!-- .contact-content -->
                </div> <!-- .main-page -->
            </div> <!-- .row -->

            <footer class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 footer">
                    <p class="copyright">Copyright © 2016 Company Name

                        | Design: <a rel="nofollow" href="http://www.templatemo.com" target="_parent">template mo</a></p>
                </div>    
            </footer>  <!-- .row -->   

        </div> <!-- .container -->
    </div> <!-- .main-body -->

    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
        /* Google map
         ------------------------------------------------*/
        var map = '';
        var center;

        function initialize() {
            var mapOptions = {
                zoom: 16,
                center: new google.maps.LatLng(13.758468, 100.567481),
                scrollwheel: false
            };

            map = new google.maps.Map(document.getElementById('google-map'), mapOptions);

            google.maps.event.addDomListener(map, 'idle', function () {
                calculateCenter();
            });

            google.maps.event.addDomListener(window, 'resize', function () {
                map.setCenter(center);
            });
        } // initialize

        function calculateCenter() {
            center = map.getCenter();
        }

        function loadGoogleMap() {
            var script = document.createElement('script');
            script.type = 'text/javascript';
            script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&' + 'callback=initialize';
            document.body.appendChild(script);
        }

        // DOM is ready.
        $(document).ready(function () {
            loadGoogleMap();
        });
    </script>
</body>
</html>
