import "./Home.scss";
import Sidebar from "../../Layout/SideBar";
import Featured from "../../Components/Featured";
import Widget from "../../Components/Widget";
import Chart from "../../Components/Chart";
import List from "../List";

const HomeAdmin = () => {
    return (
        <div style={{margin:'auto'}}>
            <div className="home ">
                <div className="homeContainer">
                    <div className="widgets row ">
                        <div className='col-sm-12 col-md-6 col-lg-3'>
                            <Widget type="user" />
                        </div>
                        <div className='col-sm-12 col-md-6 col-lg-3'>
                            <Widget type="order" />
                        </div>
                        <div className='col-sm-12 col-md-6 col-lg-3'>
                            <Widget type="earning" />
                        </div>
                        <div className='col-sm-12 col-md-6 col-lg-3'>
                            <Widget type="balance" />
                        </div>

                    </div>
                    <div className="charts row">
                        <div className='col-sm-12 col-md-4 col-lg-3'>
                            <Featured />
                        </div>
                        <div className='col-sm-12 col-md-8 col-lg-9'>
                            <Chart title="Last 6 Months (Revenue)" aspect={2 / 1} />
                        </div>
                    </div>
                    <div className="listContainer">
                        <div className="listTitle">Latest Transactions</div>
                        {/*<List/>*/}
                    </div>
                </div>
            </div>
        </div>

    );
};

export default HomeAdmin;