import React from 'react';
import {Link} from 'react-router-dom'
import TwitterIcon from '@mui/icons-material/Twitter';
import FacebookIcon from '@mui/icons-material/Facebook';
import InstagramIcon from '@mui/icons-material/Instagram';
import GoogleIcon from '@mui/icons-material/Google';
import Count from "./Count/count";
const Booking = () => {
    return (
        <div>
            <section className="ftco-section ftco-services">
                <div className="container">
                    <div className="row justify-content-center mb-5 pb-5">
                        <div className="col-md-7 text-center heading-section ftco-animate">
                            <h2 className="mb-2">Our Service Keeps you Smile</h2>
                            <p>A small river named Duden flows by their place and supplies it with the necessary
                                regelialia.</p>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-md-3 d-flex align-self-stretch ftco-animate">
                            <div className="media block-6 services d-block text-center">
                                <div className="icon d-flex justify-content-center align-items-center">
                                    <span className="flaticon-tooth-1"></span>
                                </div>
                                <div className="media-body p-2 mt-3">
                                    <h3 className="heading">Teeth Whitening</h3>
                                    <p>Even the all-powerful Pointing has no control about the blind texts it is an
                                        almost unorthographic.</p>
                                </div>
                            </div>
                        </div>
                        <div className="col-md-3 d-flex align-self-stretch ftco-animate">
                            <div className="media block-6 services d-block text-center">
                                <div className="icon d-flex justify-content-center align-items-center">
                                    <span className="flaticon-dental-care"></span>
                                </div>
                                <div className="media-body p-2 mt-3">
                                    <h3 className="heading">Teeth Cleaning</h3>
                                    <p>Even the all-powerful Pointing has no control about the blind texts it is an
                                        almost unorthographic.</p>
                                </div>
                            </div>
                        </div>
                        <div className="col-md-3 d-flex align-self-stretch ftco-animate">
                            <div className="media block-6 services d-block text-center">
                                <div className="icon d-flex justify-content-center align-items-center">
                                    <span className="flaticon-tooth-with-braces"></span>
                                </div>
                                <div className="media-body p-2 mt-3">
                                    <h3 className="heading">Quality Brackets</h3>
                                    <p>Even the all-powerful Pointing has no control about the blind texts it is an
                                        almost unorthographic.</p>
                                </div>
                            </div>
                        </div>
                        <div className="col-md-3 d-flex align-self-stretch ftco-animate">
                            <div className="media block-6 services d-block text-center">
                                <div className="icon d-flex justify-content-center align-items-center">
                                    <span className="flaticon-anesthesia"></span>
                                </div>
                                <div className="media-body p-2 mt-3">
                                    <h3 className="heading">Modern Anesthetic</h3>
                                    <p>Even the all-powerful Pointing has no control about the blind texts it is an
                                        almost unorthographic.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="container-wrap mt-5">
                    <div className="row d-flex no-gutters">
                        <div className="col-md-6 img image_booking " >
                        </div>
                        <div className="col-md-6 d-flex" style={{padding:"unset"}}>
                            <div className="about-wrap" style={{backgroundColor:'#2F91F3', color:"whitesmoke"}}>
                                <div className="heading-section heading-section-white mb-5 ftco-animate pt-5  p-4 m-5"
                                     style={{width:'80%',margin:"auto"}}
                                >
                                    <h2 className="mb-2 fs-1">Dentacare with a personal touch</h2>
                                    <p>A small river named Duden flows by their place and supplies it with the necessary
                                        regelialia.</p>
                                </div>
                                <div className="list-services d-flex ftco-animate">
                                    <div className="icon d-flex justify-content-center align-items-center">
                                        <span className="icon-check2"></span>
                                    </div>
                                    <div className="text mb-5 ftco-animate p-4 " style={{marginLeft:23}}>
                                        <h2 className="mb-2 fs-1">Well Experience Dentist</h2>
                                        <p>Far far away, behind the word mountains, far from the countries Vokalia and
                                            Consonantia, there live the blind texts.</p>
                                    </div>
                                </div>
                                <div className="text mb-5 ftco-animate p-4 " style={{marginLeft:23}}>
                                    <div className="icon d-flex justify-content-center align-items-center">
                                        <span className="icon-check2"></span>
                                    </div>
                                    <div className="text">
                                        <h2 className="mb-2 fs-1">High Technology Facilities</h2>
                                        <p>Far far away, behind the word mountains, far from the countries Vokalia and
                                            Consonantia, there live the blind texts.</p>
                                    </div>
                                </div>
                                <div className="text mb-5 ftco-animate p-4 " style={{marginLeft:23}}>
                                    <div className="icon d-flex justify-content-center align-items-center">
                                        <span className="icon-check2"></span>
                                    </div>
                                    <div className="text">
                                        <h2 className="mb-2 fs-1">Comfortable Clinics</h2>
                                        <p>Far far away, behind the word mountains, far from the countries Vokalia and
                                            Consonantia, there live the blind texts.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section className="ftco-section">
                <div className="container">
                    <div className="row justify-content-center mb-5 pb-5">
                        <div className="col-md-7 text-center heading-section ftco-animate">
                            <h2 className="mb-3">Meet Our Experience Dentist</h2>
                            <p>A small river named Duden flows by their place and supplies it with the necessary
                                regelialia. It is a paradisematic country, in which roasted parts of sentences</p>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-lg-3 col-md-6 d-flex mb-sm-4 ftco-animate">
                            <div className="staff" style={{padding:25,boxShadow:'rgba(100, 100, 111, 0.2) 0px 7px 29px 0px'}}>
                                <div className="img mb-4 text-center" >
                                    <img src={'https://thumbs.dreamstime.com/b/portrait-indian-doctor-portrait-male-indian-doctor-serious-expression-crossed-arms-wearing-white-coat-having-open-137577527.jpg'}
                                         alt=""
                                         style={{
                                             width:200,
                                             height:200,
                                             borderRadius:'50%'
                                         }}
                                    />
                                </div>
                                <div className="info text-center">
                                    <h3><Link to='/'>Tom Smith</Link></h3>
                                    <span className="position">Dentist</span>
                                    <div className="text">
                                        <p>Far far away, behind the word mountains, far from the countries Vokalia</p>
                                        <ul className="ftco-social text-center mt-5" style={{
                                            listStyle:'none',
                                            display:'flex',
                                            justifyContent:'space-evenly',
                                            padding:'unset'
                                        }}>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><TwitterIcon/></span>
                                                </Link>
                                            </li>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><FacebookIcon/></span>
                                                </Link>
                                            </li>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><InstagramIcon/></span>
                                                </Link>
                                            </li>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><GoogleIcon/></span>
                                                </Link>
                                            </li>
                                        </ul>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div className="col-lg-3 col-md-6 d-flex mb-sm-4 ftco-animate">
                            <div className="staff" style={{padding:25,boxShadow:'rgba(100, 100, 111, 0.2) 0px 7px 29px 0px'}}>
                                <div className="img mb-4 text-center" >
                                    <img src={'https://thumbs.dreamstime.com/b/portrait-indian-doctor-portrait-male-indian-doctor-serious-expression-crossed-arms-wearing-white-coat-having-open-137577527.jpg'}
                                         alt=""
                                         style={{
                                             width:200,
                                             height:200,
                                             borderRadius:'50%'
                                         }}
                                    />
                                </div>
                                <div className="info text-center">
                                    <h3><Link to='/'>Tom Smith</Link></h3>
                                    <span className="position">Dentist</span>
                                    <div className="text">
                                        <p>Far far away, behind the word mountains, far from the countries Vokalia</p>
                                        <ul className="ftco-social text-center mt-5" style={{
                                            listStyle:'none',
                                            display:'flex',
                                            justifyContent:'space-evenly',
                                            padding:'unset'
                                        }}>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><TwitterIcon/></span>
                                                </Link>
                                            </li>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><FacebookIcon/></span>
                                                </Link>
                                            </li>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><InstagramIcon/></span>
                                                </Link>
                                            </li>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><GoogleIcon/></span>
                                                </Link>
                                            </li>
                                        </ul>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div className="col-lg-3 col-md-6 d-flex mb-sm-4 ftco-animate">
                            <div className="staff" style={{padding:25,boxShadow:'rgba(100, 100, 111, 0.2) 0px 7px 29px 0px'}}>
                                <div className="img mb-4 text-center" >
                                    <img src={'https://thumbs.dreamstime.com/b/portrait-indian-doctor-portrait-male-indian-doctor-serious-expression-crossed-arms-wearing-white-coat-having-open-137577527.jpg'}
                                         alt=""
                                         style={{
                                             width:200,
                                             height:200,
                                             borderRadius:'50%'
                                         }}
                                    />
                                </div>
                                <div className="info text-center">
                                    <h3><Link to='/'>Tom Smith</Link></h3>
                                    <span className="position">Dentist</span>
                                    <div className="text">
                                        <p>Far far away, behind the word mountains, far from the countries Vokalia</p>
                                        <ul className="ftco-social text-center mt-5" style={{
                                            listStyle:'none',
                                            display:'flex',
                                            justifyContent:'space-evenly',
                                            padding:'unset'
                                        }}>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><TwitterIcon/></span>
                                                </Link>
                                            </li>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><FacebookIcon/></span>
                                                </Link>
                                            </li>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><InstagramIcon/></span>
                                                </Link>
                                            </li>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><GoogleIcon/></span>
                                                </Link>
                                            </li>
                                        </ul>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div className="col-lg-3 col-md-6 d-flex mb-sm-4 ftco-animate">
                            <div className="staff" style={{padding:25,boxShadow:'rgba(100, 100, 111, 0.2) 0px 7px 29px 0px'}}>
                                <div className="img mb-4 text-center" >
                                    <img src={'https://thumbs.dreamstime.com/b/portrait-indian-doctor-portrait-male-indian-doctor-serious-expression-crossed-arms-wearing-white-coat-having-open-137577527.jpg'}
                                         alt=""
                                         style={{
                                             width:200,
                                             height:200,
                                             borderRadius:'50%'
                                         }}
                                    />
                                </div>
                                <div className="info text-center">
                                    <h3><Link to='/'>Tom Smith</Link></h3>
                                    <span className="position">Dentist</span>
                                    <div className="text">
                                        <p>Far far away, behind the word mountains, far from the countries Vokalia</p>
                                        <ul className="ftco-social text-center mt-5" style={{
                                            listStyle:'none',
                                            display:'flex',
                                            justifyContent:'space-evenly',
                                            padding:'unset'
                                        }}>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><TwitterIcon/></span>
                                                </Link>
                                            </li>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><FacebookIcon/></span>
                                                </Link>
                                            </li>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><InstagramIcon/></span>
                                                </Link>
                                            </li>
                                            <li className="ftco-animate">
                                                <Link to="#">
                                                    <span className="icon-twitter"><GoogleIcon/></span>
                                                </Link>
                                            </li>
                                        </ul>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="row  mt-5 justify-conten-center">
                        <div className="col-md-8 ftco-animate">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi vero accusantium sunt sit
                                aliquam ipsum molestias autem perferendis, incidunt cumque necessitatibus cum amet
                                cupiditate, ut accusamus. Animi, quo. Laboriosam, laborum.</p>
                        </div>
                    </div>
                </div>
            </section>
            <section className="ftco-section ftco-counter img count_number" id="section-counter"
                      data-stellar-background-ratio="0.5">
                <div className="container">
                    <div className="row d-flex align-items-center">
                        <div className="col-md-3 aside-stretch py-5 mt-5 " style={{marginTop:50}}>
                            <div className=" text-while heading-section heading-section-white ftco-animate pr-md-4 ">
                                <h2 className="mb-3 text-white fs-1">Achievements</h2>
                                <p className='text-white fs-2'>A small river named Duden flows by their place and supplies it with the necessary
                                    regelialia.</p>
                            </div>
                        </div>
                        <div className="col-md-9 py-5 pl-md-5 mt-5" style={{padding:10}}>
                            <div className="row">
                                <div className="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
                                    <div className="block-18">
                                        <div className="text">
                                            <strong className="number" data-number="14"><Count end={15} /></strong>
                                            <span style={{color:"whitesmoke"}}>Years of Experience</span>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
                                    <div className="block-18">
                                        <div className="text">
                                            <strong className="number" data-number="4500"><Count end={4500}/></strong>
                                            <span style={{color:"whitesmoke"}}>Qualified Dentist</span>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
                                    <div className="block-18">
                                        <div className="text">
                                            <strong className="number" data-number="4200"><Count end={4200}/></strong>
                                            <span style={{color:"whitesmoke"}}>Happy Smiling Customer</span>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
                                    <div className="block-18">
                                        <div className="text">
                                            <strong className="number" data-number="320"><Count end={320}/></strong>
                                            <span style={{color:"whitesmoke"}}>Patients Per Year</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section className="ftco-section">
                <div className="container">
                    <div className="row justify-content-center mb-5 pb-5">
                        <div className="col-md-7 text-center heading-section ftco-animate">
                            <h2 className="mb-3">Our Best Pricing</h2>
                            <p>A small river named Duden flows by their place and supplies it with the necessary
                                regelialia.</p>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-md-3 ftco-animate" style={{fontSize:'1.6rem'}}>
                            <div className="pricing-entry pb-5 text-center"
                                 style={{
                                     padding:10,
                                     boxShadow:'rgba(100, 100, 111, 0.2) 0px 7px 29px 0px'
                            }}>
                                <div>
                                    <h3 className="mb-4 fs-1">BASIC</h3>
                                    <p><span className="price text-info fs-1">$24.50</span> <span className="per fs-5">/ session</span></p>
                                </div>
                                <ul style={{
                                    listStyle:"none",
                                    padding:"unset",

                                }}>
                                    <li>Diagnostic Services</li>
                                    <li>Professional Consultation</li>
                                    <li>Tooth Implants</li>
                                    <li>Surgical Extractions</li>
                                    <li>Teeth Whitening</li>
                                </ul>
                                <p className="button text-center">
                                    <Link to='/'  className="btn btn-primary px-5 py-3 fs-3" >Order
                                    now</Link>
                                </p>
                            </div>
                        </div>
                        <div className="col-md-3 ftco-animate" style={{fontSize:'1.6rem'}}>
                            <div className="pricing-entry pb-5 text-center"
                                 style={{
                                     padding:10,
                                     boxShadow:'rgba(100, 100, 111, 0.2) 0px 7px 29px 0px'
                                 }}>
                                <div>
                                    <h3 className="mb-4 fs-1">STANDARD</h3>
                                    <p><span className="price text-info fs-1">$34.50</span> <span className="per fs-5">/ session</span></p>
                                </div>
                                <ul style={{
                                    listStyle:"none",
                                    padding:"unset",

                                }}>
                                    <li>Diagnostic Services</li>
                                    <li>Professional Consultation</li>
                                    <li>Tooth Implants</li>
                                    <li>Surgical Extractions</li>
                                    <li>Teeth Whitening</li>
                                </ul>
                                <p className="button text-center">
                                    <Link to='/'  className="btn btn-primary px-5 py-3 fs-3" >Order
                                        now</Link>
                                </p>
                            </div>
                        </div>
                        <div className="col-md-3 ftco-animate" style={{fontSize:'1.6rem'}}>
                            <div className="pricing-entry pb-5 text-center"
                                 style={{
                                     padding:10,
                                     boxShadow:'rgba(100, 100, 111, 0.2) 0px 7px 29px 0px'
                                 }}>
                                <div>
                                    <h3 className="mb-4 fs-1">PREMIUM</h3>
                                    <p><span className="price text-info fs-1">$54.50 </span> <span className="per fs-5">/ session</span></p>
                                </div>
                                <ul style={{
                                    listStyle:"none",
                                    padding:"unset",

                                }}>
                                    <li>Diagnostic Services</li>
                                    <li>Professional Consultation</li>
                                    <li>Tooth Implants</li>
                                    <li>Surgical Extractions</li>
                                    <li>Teeth Whitening</li>
                                </ul>
                                <p className="button text-center">
                                    <Link to='/'  className="btn btn-primary px-5 py-3 fs-3" >Order
                                        now</Link>
                                </p>
                            </div>
                        </div>
                        <div className="col-md-3 ftco-animate" style={{fontSize:'1.6rem'}}>
                            <div className="pricing-entry pb-5 text-center"
                                 style={{
                                     padding:10,
                                     boxShadow:'rgba(100, 100, 111, 0.2) 0px 7px 29px 0px'
                                 }}>
                                <div>
                                    <h3 className="mb-4 fs-1">PLATINUM</h3>
                                    <p><span className="price text-info fs-1">$89.50</span> <span className="per fs-5">/ session</span></p>
                                </div>
                                <ul style={{
                                    listStyle:"none",
                                    padding:"unset",

                                }}>
                                    <li>Diagnostic Services</li>
                                    <li>Professional Consultation</li>
                                    <li>Tooth Implants</li>
                                    <li>Surgical Extractions</li>
                                    <li>Teeth Whitening</li>
                                </ul>
                                <p className="button text-center">
                                    <Link to='/'  className="btn btn-primary px-5 py-3 fs-3" >Order
                                        now</Link>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    );
};

export default Booking;