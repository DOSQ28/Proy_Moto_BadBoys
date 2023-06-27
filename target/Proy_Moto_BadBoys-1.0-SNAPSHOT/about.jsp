
<jsp:include page="arriba.jsp"/>

<body>
    <div class="main-body">	
        <div class="container">
            <div class="row">               
                <div class="main-page">

                    <jsp:include page="menu.jsp"/> 

                    <div class="content-main">
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div class="banner-main-about margin-b-30">
                                    <div class="banner-main-about-text">
                                        <div class="heading2">
                                            <p>BIENVENIDO A TU TIENDA FAVORITA</p>
                                            <h1>BAD BOYS</h1>
                                        </div>
                                        <div class="desc2">
                                            <ul>
                                                <li>Preparate para la velocidad.</li>
                                                <li>Listo para tener mas de un chica.</li>
                                                <li>Podras sentir la sensacion de volar.</li>
                                                <li>Ella es feliz con otro pero tu eres feliz con tu moto.</li>
                                                <li>ESCOJE TU FAVORITA.</li>
                                            </ul>
                                            <button type="button" class="">COMIENZA</button>
                                        </div>
                                    </div>
                                    <img src="images/about-img-1.png" alt="Image" class="img-responsive">
                                </div>    
                            </div>                                                        
                        </div> <!-- .banner-main-about -->

                        <!-- Modals -->
                        <div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <img src="images/about-img-2.jpg" alt="Image" class="img-responsive">
                                    </div> <!-- .modal-body -->
                                </div> <!-- .modal-content -->
                            </div> <!-- .modal-dialog -->
                        </div> <!-- #myModal -->
                        <div id="myModal2" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <img src="images/about-img-3.jpg" alt="Image" class="img-responsive">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="myModal3" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-body">
                                        <img src="images/about-img-4.jpg" alt="Image" class="img-responsive">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row about-box-main">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

                                <div class="cards">
                                    
                                    <div class="box about_box_line card">
                                        <div class="box-icon">
                                            <img src="images/about-img-2.jpg" alt="Image" class="img-responsive">
                                            <div class="inner_search">
                                                <div class="search_icon text-center Absolute-Center" data-toggle="modal" data-target="#myModal"><i class="fa fa-search"></i></div>
                                            </div> <!-- .inner_search -->
                                        </div> <!-- .box-icon -->
                                        <div class="info">
                                            <div class="about_box_title">
                                                <h3>BELLESA NINJA</h3>
                                                <h4>SE QUE ME DESEAS</h4>
                                            </div>
                                        </div> <!-- .info -->
                                        <div class="line"></div>
                                        <p class="about_box_text">ADQUIEREME!</p>
                                    </div>
                                
                                    <div class="box about_box_line card">
                                        <div class="box-icon">
                                            <img src="images/about-img-3.jpg" alt="Image" class="img-responsive">
                                            <div class="inner_search">
                                                <div class="search_icon text-center Absolute-Center" data-toggle="modal" data-target="#myModal2"><i class="fa fa-search"></i></div>
                                            </div>
                                        </div>
                                        <div class="info">
                                            <div class="about_box_title">
                                                <h3>UN CALSISCO </h3>
                                                <h4>MUITA BELEZA!</h4>
                                            </div>
                                        </div>
                                        <div class="line"></div>
                                        <p class="about_box_text">COMPRAME!</p>
                                    </div>

                                    <div class="box about_box_line card">
                                        <div class="box-icon">
                                            <img src="images/about-img-4.jpg" alt="Image" class="img-responsive">
                                            <div class="inner_search">
                                                <div class="search_icon text-center Absolute-Center" data-toggle="modal" data-target="#myModal3"><i class="fa fa-search"></i></div>
                                            </div> <!-- .inner_search -->
                                        </div> <!-- .box-icon -->
                                        <div class="info">
                                            <div class="about_box_title">
                                                <h3>ADRENALINA</h3>
                                                <h4>QUIERES ACCION ?</h4>
                                            </div>
                                        </div>
                                        <div class="line"></div>
                                        <p class="about_box_text">QUE ESPERAS !</p>
                                    </div>
                                      
                                </div>
                                
                            </div>
                            
                        </div>

                        <div class="row margin-b-30">
                            <div class="col-xs-12 col-sm-12 col-md-12 biliend">
                                <div class="banner-2-container">
                                    <div class="aenean">
                                        <h4>RECUERDA SOMO EL GRUPO </h4>
                                        <h3>BAD BOYS</h3>
                                    </div>    
                                </div>                                
                            </div>
                        </div>
                        <!-- <div class="row"> -->
                            <div class="about-last-container">
                                <!-- <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4"> -->
                                   <div class="box bottom-main info-nav-container">
                                        <ul class="info info-ul">
                                            <li><a href="#" class="about_proin current">TECNOLOGIAS EMERGENTES</a></li>
                                            <li><a href="#" class="about_proin">BELLEZA</a></li>
                                            <li><a href="#" class="about_proin">SOPORTE</a></li>
                                            <li><a href="#" class="about_proin">MEJORA</a></li>
                                            <li><a href="#" class="about_proin">VELOCIDAD</a></li>
                                            <li><a href="#" class="about_proin">ULTRA</a></li> 
                                            <li><a href="#" class="about_proin">BAD BOYS</a></li>
                                            <li><a href="#" class="about_proin">DALE</a></li>
                                            <li><a href="#" class="about_proin">EL QUE TENGA MIEDO A MORIR QUE NO NASCA</a></li>
                                        </ul>
                                    </div>
                                <!-- </div> -->    
                                <!-- <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8"> -->
                                    <div class="box bottom-main info-description-container">
                                        <div class="info">
                                            <div class="proin-title">
                                                <h3>MIRALA</h3>
                                                <h4>QUE MIRA BOBO!</h4>
                                            </div>                                       
                                            <img src="images/about-img-5.png" alt="Image" class="img-responsive">
                                            <p class="proin-right-text">ESTA ES LA MOTO DE MIS SUEÑOS QUE LA COMPRARE CUANDO SEA ING .</p>
                                        </div> <!-- .info -->
                                    </div>
                                <!-- </div> -->
                            </div>
                        <!-- </div> -->
                    </div>
                </div>
            </div>
            <footer class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 footer">
                    <p class="copyright">Copyright © 2016 Company Name
                    
                    | Design: <a rel="nofollow" href="http://www.templatemo.com" target="_parent">template mo</a></p>
                </div>    
            </footer>            
        </div>
    </div>

    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</body>
</html>
