import React, {useEffect, useState} from 'react';
import './MyAccount.scss'
import {Link} from 'react-router-dom'




const MyAccount = () => {

    const [data, setData] = useState(null)

    useEffect(() => {
        fetch("http://localhost:8080/api/v1/users")
            .then((res) => res.json())
            .then((res) => {
                setData(res)
            })
    },[])
    var listUser = []
    if(data !== null) {
        listUser = data.map((item) => {
            return(
                <tbody>
                <tr>
                    <th scope="row">{item.id}</th>
                    <td>{item.firstName}</td>
                    <td>{item.lastName}</td>
                    <td>{item.email}</td>
                </tr>

                </tbody>
            )
        })
    }


    return (
        <div style={{width:'85%'}} className=' my_account'>
            <div className=' col profiles'>
                <div style={{padding:'unset'}}>
                    {/*<div>
                        {err && showErrMsg(err)}
                        {success && showSuccessMsg(success)}
                        {loading && <h3>Loading.....</h3>}
                    </div>*/}
                    <h1 style={{padding:10}}>My Account</h1>
                    <div className='form_account'>
                        <div className='banner'></div>
                        <div className='info_account'>
                            <img src='' alt="Avatar"/>
                            {/*chang avatar*/}
                            <div className='info_name'>
                                <div>
                                    <span></span>
                                </div>
                                <button >
                                    <Link to='#'>Edit Profile</Link>
                                </button>
                            </div>
                        </div>
                        <div className='edit_profile'>
                            <div className='edit_profile_name'>
                                <span>
                                    <strong>Tên đăng nhập :</strong><br/>
                                    <span>Hải Nguyễn</span>
                                </span>

                                <button>
                                    <Link to='/'>Edit</Link>
                                </button>
                            </div><br/>
                            <div className='edit_profile_name'>
                                <span>
                                    <strong>Email :</strong><br/>
                                    <span>abc@gmail.com</span>
                                </span>

                                <button>
                                    <Link to='/'>Edit</Link>
                                </button>
                            </div><br/>
                            <div className='edit_profile_name'>
                                <span>
                                    <strong>Password :</strong><br/>
                                    <span>************</span>
                                </span>

                                <button>
                                    <Link to='/'>Edit</Link>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <table className="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Email</th>
                </tr>
                </thead>
            </table>
        </div>
    );
};

export default MyAccount;