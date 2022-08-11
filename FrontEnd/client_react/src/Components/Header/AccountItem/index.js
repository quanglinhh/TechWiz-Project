import React from 'react';
import './AccountItem.scss'
import {Link} from "react-router-dom";
const AccountItem = ({data}) => {
    return (
        <div className='wrappers'>
            <img className='avatar' src={data.image} alt={data.firstName}/>
            <div className="info">
                <p className="name">
                    {/*{data.sub_tag == "France" ? (*/}
                    {/*    <span>{data.title}</span>*/}
                    {/*):(*/}
                    {/*    <span>{data.title}</span>*/}
                    {/*)}*/}
                    <Link className={'search-account-link'} to={'/page/' + data.id}>
                        <span>{data.title}</span>
                    </Link>
                    {/*{data.status === true && (*/}
                    {/*    <FiberManualRecordIcon/>*/}
                    {/*)}*/}
                </p>
                <span className="username">{data.firstName}</span>
            </div>
        </div>
    );
};

export default AccountItem;
