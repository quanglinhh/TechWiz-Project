import React, {useState} from 'react';
import {Link} from "react-router-dom";
import './style.scss'


const SignIn  = () => {


    return (
        <div className='container signin'>
            <div style={{width:400}}>

                <div>
                    <h1>Sign in to your account</h1>
                </div>

                <form className='sign-form' >
                    <div >
                        <label>Email Address</label><br/>
                        <input
                            className='input-signin'
                            type='email'
                            id='email'
                            name='email'
                           /* value={email}
                            onChange={handleChangeInput}*/
                        />
                    </div>
                    <div>
                        <label>Password</label><br/>
                        <input
                            className='input-signin'
                            type='password'
                            id='password'
                            name='password'
                           /* value={password}
                            onChange={handleChangeInput}*/
                        />
                    </div>
                    <div>
                        <input type="checkbox"/>
                        <label> Remember me</label>
                    </div>
                    <button

                        // onFocus={handleSubmit(onSubmit)}
                        className='sign-btn' type='submit'>
                        Sign In
                    </button>

                    <p className='mt-5 text-center'>
                        Don't have an account yet?{' '}
                        <Link to='/signup' >
                            Sign up.
                        </Link><br/>

                    </p>
                    <p className=' text-center'>
                        <Link to='/forgot' style={{color:'#ff3300'}} >
                            Forgot your password ?
                        </Link>
                    </p>
                </form>

            </div>
        </div>
    );
};

export default SignIn ;