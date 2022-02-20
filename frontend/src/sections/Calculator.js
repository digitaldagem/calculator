import React, { useState } from "react";
import axios from "axios";
import { Box, Grid } from "@material-ui/core";
import HistoryIcon from "@mui/icons-material/History";
import { Link } from "react-router-dom";

import ResetSubmitRow from "./components/ResetSubmitRow";
import RegularRow from "./components/RegularRow";

import useStyles from "./styling/styling";

const Calculator = () => {
  const classes = useStyles();

  const [firstValue, setFirstValue] = useState("0");
  const [secondValue, setSecondValue] = useState("");
  const [operator, setOperator] = useState("");
  const [resultValue, setResultValue] = useState("");

  const clickedOperator = (value) => {
    resultValue !== "" ? clear("0")
    : secondValue !== "" ? console.log("second value is not empty.")
    : value !== "-" && operator !== "" ? console.log("operator is not empty.")
    : value === "-" && firstValue === "0" && operator === "" ? setFirstValue(value)
    : value === "-" && operator !== "" && secondValue === "" ? setSecondValue(value)
    : setOperator(value);
  }

  const clickedEquals = (endpoint) => {
    secondValue !== "" ?
      axios.post(`http://localhost:8080/${endpoint}`,
        {
          firstValue: parseFloat(firstValue, 10),
          operator: operator,
          secondValue: parseFloat(secondValue, 10)
        }
      ).then((response) => {
        setResultValue("= " + response.data.result);
      })
      .catch((error) => console.log(error.data))
    : console.log("second value is empty.");
  }

  const clickedNumber = (value) => {
    resultValue !== "" ? clear(value)
    : operator === "" ?
      !firstValue.includes(".") ?
        firstValue === "0" && value !== "." ? setFirstValue(value)
        : setFirstValue(firstValue + "" + value)
      : firstValue.includes(".") ?
        value === "." ? setFirstValue(firstValue)
        : setFirstValue(firstValue + "" + value)
      : setFirstValue(value)
    : !secondValue.includes(".") ?
        secondValue === "0" && value !== "." ? setSecondValue(value)
        : setSecondValue(secondValue + "" + value)
      : secondValue.includes(".") ?
        value === "." ? setSecondValue(secondValue)
        : setSecondValue(secondValue + "" + value)
    : setSecondValue(value);
  };

  const deleteOne = () => {
    resultValue !== "" ? clear("0")
    : operator === "" ?
      firstValue.length === 1 ? setFirstValue("0")
      : setFirstValue(firstValue.substring(0, firstValue.length - 1))
    : secondValue.length === 0 ? setOperator("")
    : setSecondValue(secondValue.substring(0, secondValue.length - 1));
  }

  const clear = (value) => {
    setFirstValue(value);
    setOperator("");
    setSecondValue("");
    setResultValue("");
  }

  return (
    <div>
      <Grid container justifyContent="center">
        <Grid item xs={10}>
          <Box paddingTop={10}>
            <Link to='/history' className={classes.link}>
              <HistoryIcon />
            </Link>
          </Box>
        </Grid>
        <Grid item>
          <Box paddingTop={5} align="center">
            <Box  paddingBottom={2} align="right" className={classes.displayBox}>
              {firstValue} {operator} {secondValue} {resultValue}
            </Box>
            <Box paddingTop={2}>
              <RegularRow buttonProps={["7", "8", "9", "del"]} classes={classes} clickedNumber={clickedNumber}
                clickedOperator={clickedOperator} deleteOne={deleteOne}/>
              <RegularRow buttonProps={["4", "5", "6", "÷"]} classes={classes} clickedNumber={clickedNumber}
                clickedOperator={clickedOperator}/>
              <RegularRow buttonProps={["1", "2", "3", "*"]} classes={classes} clickedNumber={clickedNumber}
                clickedOperator={clickedOperator}/>
              <RegularRow buttonProps={[".", "0", "-", "+"]} classes={classes} clickedNumber={clickedNumber}
                clickedOperator={clickedOperator}/>
              <ResetSubmitRow classes={classes} operator={operator} clickedNumber={clickedNumber} 
                clickedOperator={clickedOperator} clickedEquals={clickedEquals} clear={clear}/>
            </Box>
          </Box>
        </Grid>
      </Grid>
    </div>
  );
};

export default Calculator;