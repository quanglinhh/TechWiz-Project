import React, {useRef} from 'react';
import { useTypewriter} from 'react-simple-typewriter'
import AccountItem from "../AccountItem";
import CloseIcon from "@mui/icons-material/Close";
import SearchIcon from "@mui/icons-material/Search";
import HeadlessTippy from '@tippyjs/react/headless';
import {useEffect, useState} from "react";
import Suggestions from "../AccountItem/Suggestions";
import Wrapper from "../Popper/Wrapper";
const Search = () => {

    const [searchValue, setSearchValue] = useState('');
    const [searchResult, setSearchResult] = useState([]);
    const [ showResult, setShowResult] = useState(false)

    const {text} = useTypewriter({
        words: ['Hello!!', 'Which country interests you?', 'Your next travel destination?'],
        loop: '10',
        onLoopDone: () => console.log(`loop completed after 3 runs.`),
    })
    const inputRef = useRef()
    useEffect(() => {
        if(! searchValue.trim()) {
            setSearchResult([])
            return
        }
        if(searchValue.length >= 3){
            fetch(`https://62b11da8196a9e98702f9eca.mockapi.io/blog?search=${encodeURIComponent(searchValue)}`)
                .then((res) => res.json())
                .then((res) => {
                    setSearchResult(res)
                })}
    },[searchValue])

    const handleClear = () => {
        setSearchValue('');
        inputRef.current.focus()
        setSearchResult([])
    }
    const handleHideResult = () => {
        setShowResult(false);
    };
    return (
        <div className='responsive'>
            <HeadlessTippy
                interactive
                visible={showResult && searchResult.length > 0}
                render={attrs => (
                    <div className="result-search" tabIndex='-1' {...attrs}>
                        <Wrapper>
                            <h4 className='search-account'>Suggestions</h4>
                            {/*{searchResult.map((todo) => (*/}
                            {/*    <Suggestions data={todo} key={todo.id}/>*/}
                            <Suggestions data={searchResult} key={searchResult.id}/>

                            <h4 className="search-account">Account</h4>
                            {searchResult.map((item) => (
                                <AccountItem key={item.id} data={ item}/>
                            ))}
                        </Wrapper>
                    </div>
                )}
                onClickOutside={handleHideResult}
            >
                <div className='input-search'
                    style={{}}
                >
                    <input

                        ref={inputRef}
                        type="text"
                        value={searchValue}
                        placeholder={text}
                        spellCheck={"false"}
                        onChange={e => setSearchValue(e.target.value)}
                        onFocus={() =>setShowResult(true)}
                    />
                    {!! searchValue && (
                        <button
                            className='btn-closes'
                            onClick={handleClear}

                        >
                            <CloseIcon/>
                        </button>
                    )}
                    <button className='btn-search'><SearchIcon/></button>
                </div>
            </HeadlessTippy>
        </div>
    );
};
export default Search;