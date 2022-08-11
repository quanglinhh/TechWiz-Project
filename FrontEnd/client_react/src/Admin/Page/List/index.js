import "./List.scss"
import Datatable from "../../Components/Datatable";
import {useEffect, useRef, useState} from "react";
import {Link} from "react-router-dom";
import AddIcon from '@mui/icons-material/Add';
import React from "react";


const List = () => {
    const [searchTerm, setSearchTerm] = useState('');
    const [data, setData] = useState([]);
    const inputRef = useRef(null);

    const handleChange = () => [setSearchTerm(inputRef.current.value)];
    useEffect(() => {
        let url = 'http://localhost:8080/api/v1/users';
        if (searchTerm.length > 0) {
            url = url + '?search=' + searchTerm;
        }
        console.log(url);
        fetch(url)
            .then((response) => response.json())
            .then((data) => {
                setData(data); //setStudents(data)
            });
    }, [searchTerm]);

    return (
        <div className="list" style={{marginTop:71}}>
            <div className="listContainer" >
                <div style={{width:'90%', margin:'auto'}}>
                    <div className="row">
                        <div className="col-sm-6 header-todo">
                            <div style={{height:30}} className="input-group container mt-5 mb-5">
                                <input
                                    ref={inputRef}
                                    type="search"
                                    className="form-control rounded"
                                    placeholder="Search"
                                    aria-label="Search"
                                    aria-describedby="search-addon"
                                />
                                <button
                                    type="button"
                                    className="btn btn-outline-primary"
                                    onClick={handleChange}
                                >
                                    search
                                </button>
                            </div>
                            <div className='user-title' style={{display:"flex", justifyContent:'space-between', width:'100%'}}>
                                <h1>Users</h1>
                                <p>
                                    <Link to={'/admin/users/usersedit/new'}>
                                        <button
                                            className="btn btn-primary"
                                            type="button"
                                            onClick={handleChange}
                                        >
                                            Add New <AddIcon/>
                                        </button>
                                    </Link>
                                </p>
                            </div>
                        </div>
                    </div>
                    <Datatable data={data}/>
                </div>
            </div>
        </div>
    )
}

export default List