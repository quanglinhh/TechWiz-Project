import React from 'react';
import PublicIcon from '@mui/icons-material/Public';
import {Link} from "react-router-dom";

const Suggestions = ({data}) => {
    if (data[0] !== undefined) {
        var country = data[0].sub_tag;
    }
    return (
        <div className='wrappers'>
            <button className='btn-search'><PublicIcon/></button>
            <div className="info">
                <p className="name">
                    {/*{data.tags !== null && (*/}
                    {/*    <span>{data[0].sub_tag}</span>*/}
                    <Link to={'/categories/' + country} style={{textDecoration: "none", color: "black"}}>
                        <span>{country}</span>
                    </Link>
                    {/*)}*/}
                    {/*{data.status === true && (*/}
                    {/*    <FiberManualRecordIcon/>*/}
                    {/*)}*/}
                </p>
            </div>
        </div>
    );
};

export default Suggestions;