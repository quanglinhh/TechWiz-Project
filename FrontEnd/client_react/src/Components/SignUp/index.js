import React, {useState} from 'react';
import {Link} from "react-router-dom";
import '../SignIn/style.scss'


const SignUp  = () => {



    return (
        <div className='container signin'>
            <div style={{width:400}}>

                <div>
                    <h1>Sign up for a free account</h1>
                </div>

                <form className='sign-form' >
                    <div>
                        <label>Name</label><br/>
                        <input
                            className='input-signin'
                            id='name'
                            name='name'
                           /* value={name}
                            onChange={handleChangeInput}*/
                        />

                    </div>
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
                          /*  value={password}
                            onChange={handleChangeInput}*/
                        />
                    </div>
                    <div>
                        <label>Confirm Password</label><br/>
                        <input
                            className='input-signin'
                            type='password'
                            id='cf_password'
                            name='cf_password'
                           /* value={cf_password}
                            onChange={handleChangeInput}*/
                        />
                    </div>
                    <p className='mt-5'></p>
                    <button
                        className='sign-btn' type='submit'>
                        Sign Up
                    </button>

                    <p className='mt-5 text-center'>
                        Already have an account yet?{' '}
                        <Link to='/login' >
                            Sign in.
                        </Link>
                    </p>
                </form>
            </div>
        </div>
    );
};
export default SignUp ;