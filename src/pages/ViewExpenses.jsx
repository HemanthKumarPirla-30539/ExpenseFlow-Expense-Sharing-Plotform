import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import API from "../services/api";
import "./Login.css";

function ViewExpenses() {

    const { groupId } = useParams();

    const [expenses, setExpenses] = useState([]);

    useEffect(() => {

        fetchExpenses();

    }, []);

    const fetchExpenses = async () => {

        try {

            const response =
                await API.get(
                    `/expense/groups?groupId=${groupId}`
                );

            setExpenses(response.data);

        } catch(error) {

            console.log(error);

        }
    };

    const deleteExpense = async(id) => {

        try {

            await API.delete(
                `/expense/delete?expenseId=${id}`
            );

            alert("Expense Deleted");

            fetchExpenses();

        } catch(error) {

            console.log(error);

        }
    };

    return (

        <div className="container">

            <div className="card">

                <h1>Group Expenses</h1>

                {
                    expenses.map((expense) => (

                        <div key={expense.id}>

                            <h3>
                                {expense.description}
                            </h3>

                            <p>
                                ₹{expense.amount}
                            </p>

                            <p>
                                Paid By: {expense.paidBy.membername}
                            </p>

                            <button
                                onClick={() =>
                                    deleteExpense(expense.id)
                                }
                            >
                                Delete Expense
                            </button>

                            <hr />

                        </div>

                    ))
                }

            </div>

        </div>

    );
}

export default ViewExpenses;