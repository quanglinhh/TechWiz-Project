import React, {useState, useMemo, useEffect} from 'react';
import {Table} from 'react-bootstrap'
import './datatable.scss'
import './pagination.scss'
import './Pagination'
import {Link} from "react-router-dom";
import Tippy from "@tippyjs/react";
import Pagination from "./Pagination";
let PageSize = 12;

export default function Datatable ({data}) {
    const [currentPage, setCurrentPage] = useState(0);
    const [customer, setCustomer] = useState([])
    const [direction, setDirection] = useState(1);
    const [currentData, setCurrentTableData] = useState(null);

    useEffect(() => {
        setCurrentPage(1);
        setCustomer(data);
        const firstPageIndex = 0
        const lastPageIndex = PageSize;
        setCurrentTableData([...data.slice(firstPageIndex, lastPageIndex)]);
    },[data])
    useEffect(() => {
        const firstPageIndex = (currentPage - 1) * PageSize;
        const lastPageIndex = firstPageIndex + PageSize;
        setCurrentTableData([...data.slice(firstPageIndex, lastPageIndex)]);
    }, [currentPage]);

    const sortColumn = (field, type) => {
        const sortData = [...customer];
        if (type === 'string') {
            sortData.sort((a, b) => direction * a[field].localeCompare(b[field]));
        } else if (type === 'number') {
            sortData.sort((a, b) => direction * (a[field] - b[field]));
        }
        setDirection(direction * -1);
        setCustomer(sortData);
    };

    const deleteUser = (id) => {
        fetch('http://localhost:8080/api/v1/users' + id, {
            method: 'DELETE',
        }).then(() => {
            console.log('delete successful!!');
            let result = [...customer];
            result = result.filter((item) => {
                return item.id !== id;
            });
            setCustomer(result);
        });
    };


    return (
        <div>
            <Table responsive className='table-user'>
                <thead>
                <tr>
                    <th style={{textAlign:'center'}}>ID</th>
                    <th
                        style={{textAlign:'center'}}
                        onClick={() => sortColumn('firstName', 'string')}>
                        Name
                    </th>

                    <th
                        style={{textAlign:'center'}}
                        onClick={() => sortColumn('lastName', 'string')}>
                      User Name
                    </th>
                    <th
                        style={{textAlign:'center'}}
                        onClick={() => sortColumn('lastName', 'string')}>
                        Date Of Birth
                    </th>


                    <th>Email</th>

                    <th
                        style={{textAlign:'center'}}
                        onClick={() => sortColumn('lastName', 'string')}>
                        Phone
                    </th>

                    <th style={{textAlign:'center'}}>Detail</th>
                </tr>
                </thead>
                <tbody style={{marginTop:100}}>
                {currentData&&currentData.map(item => {
                    return (
                        <tr style={{marginTop:20}}
                            key={item.id}>
                            <td style={{borderRight:'1px solid #333', textAlign:'center', width:'5%'}}>{item.id}</td>
                            <td style={{borderRight:'1px solid #333', textAlign:'center'}}>{item.name}</td>
                            <td style={{borderRight:'1px solid #333', textAlign:'center'}}>{item.username}</td>
                            <td style={{borderRight:'1px solid #333', textAlign:'center', width:'15%'}}>{(item.createdAt)}</td>
                            <td style={{borderRight:'1px solid #333', textAlign:'center', width:'25%'}}>{item.email}</td>
                            <td style={{borderRight:'1px solid #333', textAlign:'center', width:'20%'}}>{item.phone}</td>

                            <td className='Action'>
                                <Tippy placement='bottom'
                                       content={<span>Edit</span>}
                                >
                                    <Link to={'/admin/users/usersedit/' +item.id}>
                                        <button type="button" className="btn btn-outline-primary">
                                            Edit
                                        </button>
                                    </Link>
                                </Tippy>
                            </td>
                            <td style={{borderRight:'1px solid #333', textAlign:'center', width:'10%'}}>
                                <Link to={'users/' + item.id}>Details</Link>
                            </td>
                        </tr>
                    );
                })}
                </tbody>
            </Table>
            <Pagination
                className="pagination-bar"
                currentPage={currentPage}
                totalCount={data.length}
                pageSize={PageSize}
                onPageChange={page => setCurrentPage(page)}
            />
        </div>
    );
}
