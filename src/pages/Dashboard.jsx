import "./Login.css";
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import API from "../services/api";

function Dashboard() {

    const navigate = useNavigate();

    const [groupCount, setGroupCount] = useState(0);

    const [totalExpense, setTotalExpense] = useState(0);

    useEffect(() => {

        fetchStats();

    }, []);

    const fetchStats = async () => {

        try {

            const groups =
                await API.get("/groups/count");

            const expenses =
                await API.get("/expense/total");

            setGroupCount(groups.data);

            setTotalExpense(expenses.data);

        } catch(error) {

            console.log(error);

        }
    };

    const handleLogout = () => {

        localStorage.removeItem("token");
        localStorage.removeItem("username");

        navigate("/");
    };

    return (

        <div className="container">

            <div className="card">

                <h1>SplitMate</h1>

                <h3>Dashboard</h3>

                <div className="stats">

                    <div className="box">

                        <h2>{groupCount}</h2>

                        <p>Groups</p>

                    </div>

                    <div className="box">

                        <h2>₹{totalExpense}</h2>

                        <p>Expenses</p>

                    </div>

                </div>

                <button
                    onClick={() => navigate("/create-group")}
                >
                    Create Group
                </button>

                <button
                    onClick={() => navigate("/view-groups")}
                >
                    View Groups
                </button>

                <button
                    className="logout"
                    onClick={handleLogout}
                >
                    Logout
                </button>

            </div>

        </div>

    );
}

export default Dashboard;