import React, { useEffect, useState } from "react";
import {
  Box,
  Grid,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
} from "@material-ui/core";
import axios from "axios";
import { Link } from "react-router-dom";
import CalculateIcon from '@mui/icons-material/Calculate';
import DeleteSweepIcon from '@mui/icons-material/DeleteSweep';

import useStyles from "./styling/styling";

const OperationHistoryTable = () => {
  const classes = useStyles();

  const [operations, setOperations] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/"
    ).then((response) => {
      setOperations(response.data);
    });
  }, [])

  const deleteHistory = () => {
    axios.get("http://localhost:8080/delete_history"
    ).then((response) => {
      setOperations(response.data);
    });
  }

  return (
      <Grid container justifyContent="center">
        <Grid item xs={10}>
          <Box paddingTop={10} justifyContent="center">
            <DeleteSweepIcon onClick={deleteHistory} className={classes.floatLeft}/>
            <Link to="/" className={classes.link}>
              <CalculateIcon />
            </Link>
          </Box>
        </Grid>
        <Grid item xs={8}>
          <Box paddingTop={5} align="center">
            <TableContainer>
              <Table aria-label="simple table">
                <TableHead>
                  <TableRow>
                    <TableCell align="center" className={classes.tableHeader}>
                      History
                    </TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {operations.map((operation, i) => (
                    <TableRow key={i}>
                      <TableCell
                        component="th"
                        scope="row"
                        align="center"
                        className={classes.typography}
                      >
                        {`${operation.firstValue} ${operation.operatorSign} ${operation.secondValue} = ${operation.result}`}
                      </TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </TableContainer>
          </Box>
        </Grid>
      </Grid>
    );
}

export default OperationHistoryTable;