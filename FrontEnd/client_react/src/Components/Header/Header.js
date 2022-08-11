import Container from 'react-bootstrap/Container';
import './style.scss'
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import {Outlet} from "react-router-dom";
import {NavLink} from "react-router-dom";
// import LogoutIcon from '@mui/icons-material/Logout';
import 'tippy.js/dist/tippy.css';
/*import axios from "axios";
import SettingsIcon from '@mui/icons-material/Settings';
import {NavDropdown} from "react-bootstrap";
import AccountBoxIcon from '@mui/icons-material/AccountBox';*/
import Search from "./Search";
import Footer from "../Footer/Footer";

function Header() {


    // const handleLogout = async () => {
    //     try {
    //         await axios.get('/user/logout')
    //         localStorage.removeItem('firstLogin')
    //         window.location.href = "/";
    //     } catch (err) {
    //         window.location.href = "/";
    //     }
    // }

    /*const userLink = () => {
        return(
            <div>
                {isAdmin ?
                    <Nav >
                        <NavDropdown
                            id="nav-dropdown-dark-example"
                            title={
                                <img src={user.avatar} alt="" width='45' height='45' style={{borderRadius:'50%'}}/>
                            }
                            menuVariant="dark"
                        >
                            <NavLink to=' ' className='profile_name'>
                                <p className='name_image'>
                                    <img src={user.avatar} alt="" width='45' height='45' style={{borderRadius:'50%'}}/>
                                    <p>
                                        <span>{user.name}</span><br/>
                                        <span style={{fontSize:'1.3rem'}}>@{user.email}</span>
                                    </p>
                                </p>
                                <span></span>

                            </NavLink>
                            <NavLink to='/profile' className='btn_profile'><button><AccountBoxIcon/>Cá Nhân</button><br/></NavLink>
                            <NavLink to='/admin' className='btn_profile' ><button style={{marginTop:0, paddingTop:3}}><SettingsIcon style={{marginRight:2}}/>Setting</button><br/></NavLink>
                            <NavLink to='/' className='btn_Logout'>
                                <button style={{padding:2}} onClick={handleLogout}><LogoutIcon/>Log out</button><br/>
                            </NavLink>
                        </NavDropdown>
                    </Nav>

                    :
                    <Nav >
                        <NavDropdown
                            id="nav-dropdown-dark-example"
                            title={
                                <img src={user.avatar} alt="" width='45' height='45' style={{borderRadius:'50%'}}/>
                            }
                            menuVariant="dark"
                        >
                            <NavLink to=' ' className='profile_name'>
                                <p className='name_image'>
                                    <img src={user.avatar} alt="" width='45' height='45' style={{borderRadius:'50%'}}/>
                                    <p>
                                        <span>{user.name}</span><br/>
                                        <span style={{fontSize:'1.3rem'}}>@{user.email}</span>
                                    </p>
                                </p>
                                <span></span>

                            </NavLink>
                            {isAdmin
                                ?
                                <NavLink to='/admin' className='btn_profile'><button><AccountBoxIcon/>Cá Nhân</button><br/></NavLink>
                                :
                                <NavLink to='/profile' className='btn_profile'><button><AccountBoxIcon/>Cá Nhân</button><br/></NavLink>

                            }

                            <NavLink to='/' className='btn_Logout'>
                                <button onClick={handleLogout}><LogoutIcon/>Log out</button><br/>
                            </NavLink>
                        </NavDropdown>
                    </Nav>
                }
            </div>
        )
    }*/
    return (
        <div>
            <Navbar collapseOnSelect expand="lg"  variant="light" className='header' style={{height:73}}>
                <Container>
                    <Navbar.Brand href="/">
                        <img src={'https://static.saltinourhair.com/build/images/saltinourhair-logo.png'} alt="" width={'114px'} height={'23px'}/>
                    </Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav className="me-auto menu_header" >
                            <Nav.Link as={NavLink} className='nav_link' to="/" exact>Home</Nav.Link>
                            <Nav.Link as={NavLink} to="/contact" className='nav_link'  exact>Contact</Nav.Link>
                            <Nav.Link as={NavLink} to="/about" className='nav_link' exact>About</Nav.Link>
                        </Nav>
                        <Search/>
                        <Nav className='btn_Login'>
                            {/*{
                                isLogger ?
                                    userLink()
                                    :
                                    <Nav.Link
                                        className='text_btn'
                                        as={NavLink} to='/login'
                                    ><button style={{padding:'9px 20px 9px 20px', borderRadius:10, backgroundColor:'#f30' }}>Sign in </button></Nav.Link>
                            }*/}
                            <Nav.Link className='text_btn' as={NavLink} to='/login'>
                                <button style={{padding:'9px 20px 9px 20px', borderRadius:10, backgroundColor:'#f30' }}>Sign in </button>
                            </Nav.Link>
                            <Nav.Link className='text_btn' as={NavLink} to='/signup'>
                                <button style={{padding:'9px 20px 9px 20px', borderRadius:10, backgroundColor:'#f30' }}>Sign up </button>
                            </Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            
            <Outlet/>
            <Footer/>
        </div>
    );
}

export default Header;