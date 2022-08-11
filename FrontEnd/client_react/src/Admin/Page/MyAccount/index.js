import React, {useEffect, useState} from 'react';
import './MyAccount.scss'
import {Link, useParams} from 'react-router-dom'

const MyAccount = () => {
    const params = useParams();
    const [data, setData] = useState(null);
    // useEffect(() => {
    //
    //     let url =
    //         'http://localhost:8080/api/v1/users/' + params.id;
    //
    //     console.log(url);
    //     fetch(url)
    //         .then((response) => response.json())
    //         .then((data) => {
    //             data.dob = new Date(data.dob);
    //             setStudent(data); //setStudents(data)
    //         });
    // }, []);
    // const [data, setData] = useState(null)

    useEffect(() => {
        fetch("http://localhost:8080/api/v1/users")
            .then((res) => res.json())
            .then((res) => {
                setData(res)
                console.log(res)
            })
    },[])
    var listUser = []
    if(data !== null) {
        listUser = data.map((item) => {
            return(
                <div style={{width:'85%'}} className=' my_account'>
                    <div className=' col profiles'>
                        <div style={{padding:'unset'}}>
                            <h1 style={{padding:10}}>My Account</h1>
                            <div className='form_account'>
                                <div className='banner'></div>
                                <div className='info_account'>
                                    <img src='' alt="Avatar"/>
                                    {/*chang avatar*/}
                                    <div className='info_name'>
                                        <div>
                                            <span>{item.name}</span>
                                        </div>
                                        <button >
                                            <Link to={'home/useredit/' + item.id}>Edit Profile</Link>
                                        </button>
                                    </div>
                                </div>
                                <div className='edit_profile'>
                                    <div className='edit_profile_name'>
                                <span>
                                    <strong>Tên đăng nhập :</strong><br/>
                                    <span>{item.username}</span>
                                </span>

                                        <button>
                                            <Link to='/'>Edit</Link>
                                        </button>
                                    </div><br/>
                                    <div className='edit_profile_name'>
                                <span>
                                    <strong>Email :</strong><br/>
                                    <span>{item.email}</span>
                                </span>

                                        <button>
                                            <Link to={' home/useredit/' + item.id}>Edit Profile</Link>
                                        </button>
                                    </div><br/>
                                    <div className='edit_profile_name'>
                                <span>
                                    <strong>Password :</strong><br/>
                                    <span>{item.password}</span>
                                </span>

                                        <button>
                                            <Link to={'/home/useredit' + item.id}>Edit</Link>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>
            )
        })
    }

    return (
        <div>
            {listUser}
        </div>
    );
};

export default MyAccount;