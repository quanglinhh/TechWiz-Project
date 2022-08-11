

import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Header from "./Components/Header/Header";
import Home from "./Page/Home/Home";
import Contact from "./Page/Contact/Contact";
import About from "./Page/About/About";
import SignUp from "./Components/SignUp";
import Login from "./Components/SignIn";
import Nopage from "./Page/Nopage/Nopage";
import Admin from "./Admin/Admin";
import List from "./Admin/Page/List";
import Single from "./Admin/Page/Single";
import New from "./Admin/Page/New";
import HomeAdmin from "./Admin/Page/Home";

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
          <Route path='/admin/' element={<Admin/>}>
              <Route  index element={<HomeAdmin/>}/>
              <Route path='users'>
                  <Route index element={<List/>}/>
                  <Route path='users/:id' element={<Single/>}/>
                  <Route path='usersedit/:id' element={<New/>}/>
              </Route>
          </Route>
        </Routes>

      </Router>
  );
}

export default App;
