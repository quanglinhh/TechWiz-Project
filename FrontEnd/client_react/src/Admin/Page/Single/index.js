import './Single.scss'
import Chart from '../../Components/Chart'
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {Link} from 'react-router-dom'
const Single = () => {

    const params = useParams();
    const [student, setStudent] = useState(null);
    useEffect(() => {
        console.log('user use effect!!');
        let url =
            'http://localhost:8080/api/v1/users/' + params.id;

        console.log(url);
        fetch(url)
            .then((response) => response.json())
            .then((data) => {
                data.dob = new Date(data.dob);
                console.log('dob', data.dob);
                console.log('data', data);
                setStudent(data); //setStudents(data)
            });
    }, []);
    return (
        <div className="single">
            {student !== null ? (
                <div className="singleContainer">
                    <div className="top">
                        <div className="left">
                            <div className="editButton">
                                <Link to={`/admin/users/usersedit/${params.id}`}>
                                    Edit
                                </Link>
                                </div>
                            <h1 className="title">Information</h1>
                            <div className="item">
                                <img
                                    src={''}
                                    alt=""
                                    className="itemImg"
                                />
                                <div className="details">
                                    <h1 className="itemTitle">{student.name}</h1>
                                    <div className="detailItem">
                                        <span className="itemKey">Email:</span>
                                        <span className="itemValue">{student.email}</span>
                                    </div>
                                    <div className="detailItem">
                                        <span className="itemKey">Phone:</span>
                                        <span className="itemValue">{student.phone}</span>
                                    </div>
                                    <div className="detailItem">
                                        <span className="itemKey">Address:</span>
                                        <span className="itemValue">
                                        {student.home.address}<br/>
                                    </span>
                                    </div>
                                    <div className="detailItem">
                                        <span className="itemKey">Date Of Birth: </span>
                                        <span className="itemValue">{(student.createdAt)}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            ) : (
                <div className="text-center">
                    <div className="spinner-grow" role="status">
                        <span className="sr-only">Loading...</span>
                    </div>
                </div>
            )}
        </div>
    );
};

export default Single;