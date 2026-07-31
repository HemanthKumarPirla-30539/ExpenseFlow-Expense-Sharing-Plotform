import { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import API from "../services/api";
import "./Login.css";

function AddExpense() {

    const { groupId } = useParams();
    const navigate = useNavigate();

    const [description, setDescription] = useState("");
    const [amount, setAmount] = useState("");

    const [members, setMembers] = useState([]);
    const [memberId, setMemberId] = useState("");

    useEffect(() => {

        fetchMembers();

    }, []);

    const fetchMembers = async () => {

        try {

            const response =
                await API.get(
                    `/members/getgroupmembers?gId=${groupId}`
                );

            setMembers(response.data);

        } catch(error) {

            console.log(error);

        }
    };

    const handleAddExpense = async () => {

        try {

            const token =
                localStorage.getItem("token");

            const response =
                await API.post(

                    `/expense/add?memberId=${memberId}&groupId=${groupId}`,

                    {
                        description,
                        amount
                    },

                    {
                        headers: {
                            Authorization:
                                `Bearer ${token}`
                        }
                    }
                );

            alert("Expense Added Successfully");

            console.log(response.data);

            navigate("/view-groups");

        } catch(error) {

            alert("Failed To Add Expense");

            console.log(error);

        }
    };
    

    return (

        <div className="container">

            <div className="card">

                <h1>Add Expense</h1>

                <input
                    type="text"
                    placeholder="Expense Description"
                    onChange={(e) =>
                        setDescription(
                            e.target.value
                        )
                    }
                />

                <input
                    type="number"
                    placeholder="Amount"
                    onChange={(e) =>
                        setAmount(
                            e.target.value
                        )
                    }
                />

                <select
                    onChange={(e) =>
                        setMemberId(
                            e.target.value
                        )
                    }
                >

                    <option value="">
                        Select Member
                    </option>

                    {
                        members.map((member) => (

                            <option
                                key={member.id}
                                value={member.id}
                            >
                                {member.membername}
                            </option>

                        ))
                    }

                </select>

                <button
                    onClick={handleAddExpense}
                >
                    Add Expense
                </button>

            </div>

        </div>

    );
}

export default AddExpense;