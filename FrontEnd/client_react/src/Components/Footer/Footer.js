import React from 'react';

const Footer = () => {
    return (
        <footer className="ftco-footer ftco-bg-dark ftco-section" style={{backgroundColor:'#191919'}}>
            <div className="container" style={{padding:30, color:"whitesmoke"}}>
                <div className="row mb-5">
                    <div className="col-md-3">
                        <div className="ftco-footer-widget mb-4">
                            <h2 className="ftco-heading-2">DentaCare.</h2>
                            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia,
                                there live the blind texts.</p>
                        </div>
                        <ul className="ftco-footer-social list-unstyled float-md-left float-lft ">
                            <li className="ftco-animate"><a href="#"><span className="icon-twitter"></span></a></li>
                            <li className="ftco-animate"><a href="#"><span className="icon-facebook"></span></a></li>
                            <li className="ftco-animate"><a href="#"><span className="icon-instagram"></span></a></li>
                        </ul>
                    </div>
                    <div className="col-md-2">
                        <div className="ftco-footer-widget mb-4 ml-md-5">
                            <h2 className="ftco-heading-2">Quick Links</h2>
                            <ul className="list-unstyled">
                                <li><a href="#" className="py-2 d-block">About</a></li>
                                <li><a href="#" className="py-2 d-block">Features</a></li>
                                <li><a href="#" className="py-2 d-block">Projects</a></li>
                                <li><a href="#" className="py-2 d-block">Blog</a></li>
                                <li><a href="#" className="py-2 d-block">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                    <div className="col-md-4 pr-md-4">
                        <div className="ftco-footer-widget mb-4">
                            <h2 className="ftco-heading-2">Recent Blog</h2>
                            <div className="block-21 mb-4 d-flex">
                                <a className="blog-img mr-4" ></a>
                                <div className="text">
                                    <h3 className="heading"><a href="#">Even the all-powerful Pointing has no control
                                        about</a></h3>
                                    <div className="meta">
                                        <div><a href="#"><span className="icon-calendar"></span> Sept 15, 2018</a></div>
                                        <div><a href="#"><span className="icon-person"></span> Admin</a></div>
                                        <div><a href="#"><span className="icon-chat"></span> 19</a></div>
                                    </div>
                                </div>
                            </div>
                            <div className="block-21 mb-4 d-flex">
                                <a className="blog-img mr-4" ></a>
                                <div className="text">
                                    <h3 className="heading"><a href="#">Even the all-powerful Pointing has no control
                                        about</a></h3>
                                    <div className="meta">
                                        <div><a href="#"><span className="icon-calendar"></span> Sept 15, 2018</a></div>
                                        <div><a href="#"><span className="icon-person"></span> Admin</a></div>
                                        <div><a href="#"><span className="icon-chat"></span> 19</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-3">
                        <div className="ftco-footer-widget mb-4">
                            <h2 className="ftco-heading-2">Office</h2>
                            <div className="block-23 mb-3">
                                <ul>
                                    <li><span className="icon icon-map-marker"></span><span className="text">203 Fake St. Mountain View, San Francisco, California, USA</span>
                                    </li>
                                    <li><a href="#"><span className="icon icon-phone"></span><span className="text">+2 392 3929 210</span></a>
                                    </li>
                                    <li><a href="#"><span className="icon icon-envelope"></span><span
                                        className="text">info@yourdomain.com</span></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="row">
                    <div className="col-md-12 text-center">

                        <p>
                            Copyright &copy;

                            All rights reserved | This template is made with <i className="icon-heart"
                                                                                aria-hidden="true"></i> by <a
                                href="https://colorlib.com" target="_blank">Colorlib</a>
                        </p>
                    </div>
                </div>
            </div>
        </footer>
    );
};

export default Footer;