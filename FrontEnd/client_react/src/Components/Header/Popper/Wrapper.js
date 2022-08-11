import React from 'react';
import './Wapper.scss'
const Wrapper = ({children}) => {
    return (
        <div className='wrapper'>
            {children}
        </div>
    );
};

export default Wrapper;