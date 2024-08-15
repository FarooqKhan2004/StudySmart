import Button from "@mui/material/Button"
import Table from "@mui/material/Table"
import TableBody from "@mui/material/TableBody"
import TableCell from "@mui/material/TableCell"
import TableContainer from "@mui/material/TableContainer"
import TableHead from "@mui/material/TableHead"
import TableRow from "@mui/material/TableRow"
import Paper from "@mui/material/Paper"

function createData(question, answer) {
	return { question, answer }
}

const rows = [
	createData("Frozen yoghurt", 159),
	createData("Frozen yoghurt", 159),
	createData("Frozen yoghurt", 159),
	createData("Frozen yoghurt", 159),
]

export default function FlashCardsTable({ flashCards }) {
	console.log(flashCards)
	return (
		<TableContainer sx={{ width: 350 }} component={Paper}>
			<Table sx={{ width: 300 }} aria-label="simple table">
				<TableHead>
					<TableRow>
						<TableCell align="left">Question</TableCell>
						<TableCell align="right">Answer</TableCell>
					</TableRow>
				</TableHead>
				<TableBody>
					{flashCards.map((card) => (
						<TableRow
							key={card.id}
							sx={{
								"&:last-child td, &:last-child th": {
									border: 0,
								},
							}}
						>
							<TableCell component="th" scope="row">
								{card.question}
							</TableCell>
							<TableCell align="right">{card.answer}</TableCell>
						</TableRow>
					))}
				</TableBody>
			</Table>
		</TableContainer>
	)
}
