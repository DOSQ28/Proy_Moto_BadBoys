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
                                        <h3>MOTOCICLETAS</h3>
                                        <h4><a href="MotocicletaControlador?action=add" class="btn btn-primary btn-sm fa-2x"><i class="fa-solid fa-plus-minus "></i> Nuevo</a> </h4>
                                    </div>    
                                </div>                            
                            </div>

                            <table class="table table-striped">
                                <tr>
                                    <th>ID</th>
                                    <th>FOTO</th>
                                    <th>DESCRIPCION</th>
                                    <th>PLACA</th>
                                    <th>MARCA</th>
                                    <th>TIPO</th>
                                    <th>COLOR</th>
                                    <th>PRECIO</th>
                                    <th></th>
                                    <th></th>
                                </tr>                
                                <c:forEach var="item" items="${motocicletas}">        
                                    <tr>
                                        <td>${item.cod_moto}</td>
                                        <td>${item.img}</td>
                                        <td>${item.descripcion}</td>
                                        <td>${item.placa}</td>
                                        <td>${item.marca}</td>
                                        <td>${item.tipo}</td>
                                        <td>${item.color}</td>
                                        <td>${item.precio}</td>                                        
                                        <td><a href="MotocicletaControlador?action=edit&id=${item.cod_moto}"><i class="fa-solid fa-pen-to-square"></i> Editar</a></td>
                                        <td><a href="MotocicletaControlador?action=delete&id=${item.cod_moto}" onclick="return(confirm('Esta seguro???'))"><i class="fa-solid fa-trash" onclick="return(confirm('Esta Seguro ?'))"></i> Eliminar</a></td>
                                    </tr> 
                                </c:forEach> 
                            </table>                           
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
