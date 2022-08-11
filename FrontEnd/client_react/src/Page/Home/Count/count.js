import React, {useEffect, useRef, useState} from 'react';

const Count = ({end}) => {
    const[count, setCount] = useState(null)
    const ref = useRef(0)
    const accnumber = end /200
    const upDataState = () => {
        if(ref.current < end) {
            const result = Math.ceil(ref.current + accnumber)
            if (result > end) return setCount(end)
            setCount(result)
            ref.current = result
        }
        setTimeout(upDataState, 50)
    }
    useEffect(() => {
        let  isCount = true
        if (isCount) {
            upDataState()
        }
        return () => isCount = false
    }, [end])
    return (
        <div className='text-white' style={{fontSize:'4rem'}}>
            {count}
        </div>
    );
};

export default Count;