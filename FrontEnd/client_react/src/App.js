

import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Header from "./Components/Header/Header";
import Home from "./Page/Home/Home";
import Contact from "./Page/Contact/Contact";
import About from "./Page/About/About";
import SignUp from "./Components/SignUp";
import Login from "./Components/SignUp";
import Nopage from "./Page/Nopage/Nopage";

function App() {
  return (
      <Router>
        <Routes>
          <Route path='/' element={<Header/>}>
            <Route index element={<Home/>}/>
            <Route path='/contact' element={<Contact/>}/>
            <Route path='/About' element={<About/>}/>
            <Route path='/login' element={ <Login/>}/>
            <Route path='/signup' element={<SignUp/>}/>
            <Route path='*' element={<Nopage/>}/>
          </Route>
          {/*<Route path="/admin" element={<Admin/>}>
            <Route index element={<HomeAdmin/>}/>
            <Route path='home/employee' element={<MyAccount/>}/>
            <Route path='home/products' element={<Product/>}/>
            <Route path='*' element={<Nopage/>}/>
          </Route>*/}
        </Routes>

      </Router>
  );
}

export default App;
