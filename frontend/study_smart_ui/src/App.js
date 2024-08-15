import "./App.css"
import axios from "axios"
import { useEffect, useState } from "react"
import FlashCardsTable from "./components/FlashCardsTable"

const getCards = () => {
	axios.get("http://localhost:8090/api/v1/FlashCards").then((res) => {
		return res.data
	})
}

function App() {
	const [cards, setCards] = useState()

	useEffect(() => {
		axios.get("http://localhost:8090/api/v1/FlashCards").then((res) => {
			setCards(res.data)
		})
	}, [])

	return (
		<div className="App">
			<FlashCardsTable flashCards={cards} />
		</div>
	)
}

export default App
