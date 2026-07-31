import { useEffect, useState } from "react";
import API from "../services/api";
import "./Login.css";
import { useNavigate } from "react-router-dom";
function ViewGroups() {

    const navigate = useNavigate();
    const [groups, setGroups] = useState([]);

    useEffect(() => {

        fetchGroups();

    }, []);

    const fetchGroups = async () => {

        try {

            
                const username =
    localStorage.getItem("username");

const response =
    await API.get(
        `/groups/mygroups?username=${username}`
    );

            setGroups(response.data);
            console.log(response.data);

        } catch(error) {

            console.log(error);

        }
    };

    const deleteGroup = async(id) => {

    try {

        await API.delete(
            `/groups/delete?groupId=${id}`
        );

        alert("Group Deleted");

        fetchGroups();

    } catch(error) {

        console.log(error);

    }
};
    return (

        <div className="container">

            <div className="card">

                <h1>All Groups</h1>

                {
                    groups.map((group) => (
<div key={group.id}>

    <h3>{group.groupname}</h3>

    <div className="group-buttons">

        <button
            onClick={() =>
                navigate(`/add-member/${group.id}`)
            }
        >
            Add Member
        </button>

        <button
            onClick={() =>
                navigate(`/view-members/${group.id}`)
            }
        >
            View Members
        </button>

        <button
            onClick={() =>
                navigate(`/add-expense/${group.id}`)
            }
        >
            Add Expense
        </button>

        <button
            onClick={() =>
                navigate(`/view-expenses/${group.id}`)
            }
        >
            View Expenses
        </button>
        <button
    onClick={() =>
        navigate(`/settlement/${group.id}`)
    }
>
    View Settlement
</button>
<button
    onClick={() =>
        deleteGroup(group.id)
    }
>
    Delete Group
</button>

    </div>

</div>

                    ))
                }

            </div>

        </div>

    );
}

export default ViewGroups;