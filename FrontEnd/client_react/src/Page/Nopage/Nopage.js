import React from 'react';
import './404.scss'
const Nopage = () => {
    const status = "{ status : 404,  "
    const message = " message : "
    const document = `"Document not found." }`
    return (
        <div>
            <div className='not_found'>
                <div>
                    <img src={'https://www.mongodb.com/assets/images/404/sadface.gif'} alt="" width='200' height='200'/>
                </div>
                <div style={{fontSize:'2.5rem'}}>
                    <span>{status} <br/>{message} {document}</span>
                </div>
            </div>
            <div style={{textAlign:"center"}}>
                Oops! We can't find the page you were looking for.
            </div>
        </div>

    );
};

export default Nopage;