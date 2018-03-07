package by.tc.web.service.validation;

public class ConstantForValidator {
     static final String TAG_OPENED = "<[^/?][^>]+>";
     static final String TAG_CLOSED = "<[/][^>]+>";
     static final int TAG_NAME = 0;
     static final String LEVEL_VALIDATION_ERROR = "XML requires two levels and more";
     static final String TAG_NOT_FOUND = "Opening tag not found: ";
     static final String WRONG_MAIN_TAG = "Wrong main tag";
     static final String FORBIDDEN_SEQUENCE = "Forbidden sequence: ";
     static final String WRONG_AMOUNT_OF_TAGS = "Wrong amount of tags found.";
     static final String CHARSET = "UTF-8";
     static final String SPACES_BETWEEN_TAGS = ">(\\s)+<";
     static final String TAGS_WITHOUT_SPACES = "><";
     private ConstantForValidator() {}
}
