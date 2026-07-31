import { useState } from "react";
import API from "../services/api";
import "./Login.css";
import { useParams, useNavigate } from "react-router-dom";

function AddMember() {

    const { groupId } = useParams();
    const navigate = useNavigate();

    const [membername, setMembername] = useState("");
    const [email, setEmail] = useState("");

    const handleAddMember = async () => {

        try {

            const token =
                localStorage.getItem("token");

            const response =
                await API.post(

                    `/members/add?groupId=${groupId}`,

                    {
                        membername,
                        email
                    },

                    {
                        headers: {
                            Authorization:
                                `Bearer ${token}`
                        }
                    }
                );

            alert("Member Added Successfully");

            console.log(response.data);

            navigate("/view-groups");

        } catch(error) {

            alert("Failed To Add Member");

            console.log(error);

        }
    };

    return (

        <div className="container">

            <div className="card">

                <h1>Add Member</h1>

                <input
                    type="text"
                    placeholder="Enter Member Name"
                    onChange={(e) =>
                        setMembername(e.target.value)
                    }
                />

                <input
                    type="email"
                    placeholder="Enter Email"
                    onChange={(e) =>
                        setEmail(e.target.value)
                    }
                />

                <button
                    onClick={handleAddMember}
                >
                    Add Member
                </button>

            </div>

        </div>

    );
}

export default AddMember;