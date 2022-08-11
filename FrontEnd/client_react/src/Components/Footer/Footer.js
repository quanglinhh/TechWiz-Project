import React from "react";
import './footer.scss'
import AccessAlarmIcon from '@mui/icons-material/AccessAlarm';




import { Button, Card, CardImg, Col, Container, Row } from "react-bootstrap";

function Footer() {
    return (
        <div class="footer">
            <div class="container">
                <footer class="py-5">
                    <div class="row footer-content">
                        <div class="row footer-menu col-lg-8 col-md-12 col-sm-12 col-xs-12">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                <h3>Menu</h3>
                                <ul class="nav flex-column">
                                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Home</a></li>
                                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Destination</a></li>
                                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Travel</a></li>
                                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">FAQs</a></li>
                                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">About</a></li>
                                </ul>
                            </div>

                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                <h3>Section</h3>
                                <ul class="nav flex-column">
                                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Home</a></li>
                                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Features</a></li>
                                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Pricing</a></li>
                                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">FAQs</a></li>
                                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">About</a></li>
                                </ul>
                            </div>

                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                <h3>Section</h3>
                                <ul class="nav flex-column">
                                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Home</a></li>
                                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Features</a></li>
                                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Pricing</a></li>
                                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">FAQs</a></li>
                                    <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">About</a></li>
                                </ul>
                            </div>
                        </div>

                        {/* subcribe email */}
                        <div class="col-lg-4 col-md-12 col-sm-12 col-xs-12 row" id="myForm">
                            <form class="subcribe-form">
                                <div class="col-12">
                                    <h3>Subscribe to our newsletter</h3>
                                    <p>Monthly digest of whats new and exciting from us.</p>
                                </div>

                                <div class="d-flex w-100 gap-2 col-12">
                                    <input id="newsletter1" type="text" class="form-control" placeholder="Email address" />
                                    <button class="btn btn-primary" type="button">Subscribe</button>
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="d-flex justify-content-between py-4 my-4 border-top">
                        <p>&copy; 2021 Company, Inc. All rights reserved.</p>

                    </div>
                </footer>
            </div>
        </div>
    );
}

export default Footer;
