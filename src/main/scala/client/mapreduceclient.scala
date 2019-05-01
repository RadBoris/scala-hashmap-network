package client

import akka.actor.{ActorSystem, Props}
import scala.io.Source
import com.typesafe.config.ConfigFactory

import common._

 object MapReduceClient extends App {
	val system = ActorSystem("MapReduceClient", ConfigFactory.load.getConfig("client"));

  	val master = system.actorOf(Props[MasterActor], name = "master")


// val content: String = """Mr. Pickwick observed (says the secretary) that fame was dear to the
// heart of every man. Poetic fame was dear to the heart of his friend
// Snodgrass; the fame of conquest was equally dear to his friend Tupman;
// and the desire of earning fame in the sports of the field, the air,
// and the water was uppermost in the breast of his friend Winkle. He (Mr.
// Pickwick) would not deny that he was influenced by human passions and
// human feelings (cheers)--possibly by human weaknesses (loud cries of
// "No"); but this he would say, that if ever the fire of self-importance
// broke out in his bosom, the desire to benefit the human race in
// preference effectually quenched it. The praise of mankind was his swing;
// philanthropy was his insurance office. (Vehement cheering.) He had felt
// some pride--he acknowledged it freely, and let his enemies make the most
// of it--he had felt some pride when he presented his Tittlebatian Theory
// to the world; it might be celebrated or it might not. (A cry of "It
// is," and great cheering.) He would take the assertion of that honourable
// Pickwickian whose voice he had just heard--it was celebrated; but if
// the fame of that treatise were to extend to the farthest confines of the
// known world, the pride with which he should reflect on the authorship of
// that production would be as nothing compared with the pride with which
// he looked around him, on this, the proudest moment of his existence.
// (Cheers.) He was a humble individual. ("No, no.") Still he could not but
// feel that they had selected him for a service of great honour, and
// of some danger. Travelling was in a troubled state, and the minds of
// coachmen were unsettled. Let them look abroad and contemplate the scenes
// which were enacting around them. Stage-coaches were upsetting in all
// directions, horses were bolting, boats were overturning, and boilers
// were bursting. (Cheers--a voice "No.") No! (Cheers.) Let that honourable
// Pickwickian who cried "No" so loudly come forward and deny it, if he
// could. (Cheers.) Who was it that cried "No"? (Enthusiastic cheering.)
// Was it some vain and disappointed man--he would not say haberdasher
// (loud cheers)--who, jealous of the praise which had been--perhaps
// undeservedly--bestowed on his (Mr. Pickwick's) researches, and smarting
// under the censure which had been heaped upon his own feeble attempts at
// rivalry, now took this vile and calumnious mode of"""

// val pair: Content = Content ("""Mr. Pickwick observed (says the secretary) that fame was dear to the
// heart of every man. Poetic fame was dear to the heart of his friend
// Snodgrass""", "www.cnn.com")


// val repeat: Content = Content ("""Mr. Pickwick observed (says the secretary) that fame was dear to the
// heart of every man. Poetic fame was dear to the heart of his friend
// Snodgrass""", "www.example.com")

// val content: String = Source.fromURL("https://www.cnn.com").mkString
  // val content: String =

  //println(pair)

// val text: String = Source.fromURL("http://reed.cs.depaul.edu/lperkovic/csc536/homeworks/gutenberg/pg98.txt").mkString

// val text2: String = Source.fromURL("http://reed.cs.depaul.edu/lperkovic/csc536/homeworks/gutenberg/pg580.txt").mkString




val content: Content = Content ("A Tale of Two Cities", "http://reed.cs.depaul.edu/lperkovic/csc536/homeworks/gutenberg/pg98.txt")

val content2: Content = Content ( "The Pickwick papers", "http://reed.cs.depaul.edu/lperkovic/csc536/homeworks/gutenberg/pg580.txt")


 master ! content

 master ! content2

 master ! Flush
}
