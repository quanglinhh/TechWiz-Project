import React from 'react';
import './home.scss'
import AliceCarousel from 'react-alice-carousel';
import "react-alice-carousel/lib/alice-carousel.css";
import image1 from './image/bg_1.jpg'
import image2 from './image/bg_2.jpg'
import {Link} from "react-router-dom";
import Booking from "./booking";
const Home = () => {
    return (
        <div>
            <section className="home-slider owl-carousel">
                <div className="slider-item" >
                    <div className="overlay">
                        <AliceCarousel autoPlay autoPlayInterval="2000">
                            <img src={image1} className="sliderimg_1" alt=""/>
                            <img src={image2} className="sliderimg_2" alt=""/>
                        </AliceCarousel>
                    </div>
                    <div className="container slide_1">
                        <div className="row slider-text align-items-center " style={{color:"whitesmoke"}} data-scrollax-parent="true">
                            <div className="col-md-6 col-sm-12 ftco-animate"
                                 data-scrollax=" properties: { translateY: '70%' }">
                                <h1 className="mb-4" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Modern
                                    Dentistry in a Calm and Relaxed Environment</h1>
                                <p className="mb-4" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">A small
                                    river named Duden flows by their place and supplies it with the necessary
                                    regelialia.</p>
                                <p data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">
                                    <Link to='/'
                                          className="btn btn-primary px-4 py-3 text-white">
                                        Make an Appointment
                                    </Link>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <Booking/>
        </div>


    );
};

export default Home;