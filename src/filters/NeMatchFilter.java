package filters;

import song.NamedEntity;
import song.Word;

import java.util.HashSet;
import java.util.Set;

public class NeMatchFilter extends ModelWordFilter {

    public NeMatchFilter(Word model) {
        super(model);
    }

    public NeMatchFilter(Direction direction, Word model) {
        super(direction, model);
    }

    //    private Word neWord;
//
//    public FiltrationResults filter(HashSet<W2vWordSuggestion> w2vWordSuggestions, Word neWord) {
//        this.setNeWord(neWord);
//        return this.filter(w2vWordSuggestions);
//    }
//
//    public HashSet<Word> filter(HashSet<Word> w2vSuggestions, Word neWord, boolean b) {
//        this.setNeWord(neWord);
//        return this.filter(w2vSuggestions, b);
//    }
//
//    @Override
//    public FiltrationResults filter(Set<W2vWordSuggestion> w2vWordSuggestions) {
//        HashSet<W2vWordSuggestion> filteredIn = new HashSet<W2vWordSuggestion>();
//        HashSet<W2vWordSuggestion> filteredOut = new HashSet<W2vWordSuggestion>();
//        NamedEntity ne = neWord.getNe();
//        for (W2vWordSuggestion wordSuggestion : w2vWordSuggestions) {
//            W2vWordSuggestion temp = new W2vWordSuggestion(wordSuggestion.getWord(), wordSuggestion.getCosineDistance());
//            if (ne == wordSuggestion.getWord().getNe()
////                    &&
////                    (pos.equals(Pos.NN) ||
////                    pos.equals(Pos.NNS) ||
////                    pos.equals(Pos.VB) ||
////                    pos.equals(Pos.VBG) ||
////                    pos.equals(Pos.JJ) ||
////                    pos.equals(Pos.RB))
//                    )  //TODO: remove this when I'm better at Pos
//                filteredIn.add(temp);
//            else
//                filteredOut.add(temp);
//        }
//        return new FiltrationResults(filteredIn, filteredOut);
//    }


//    public Word getNeWord() {
//        return neWord;
//    }
//
//    private void setNeWord(Word neWord) {
//        this.neWord = neWord;
//    }

    @Override
    public Set doFilter(Set<Word> w2vSuggestions) {
        Set<Word> filteredIn = new HashSet<>();
        NamedEntity modelEnum = super.getModel().getNe();
        for (Word w : w2vSuggestions) {
            if (super.getDirection() == Direction.INCLUDE_MATCH && modelEnum == w.getNe() ||
                    super.getDirection() == Direction.EXCLUDE_MATCH && modelEnum != w.getNe())
                filteredIn.add(w);
        }
        return filteredIn;
    }

}














































































