package e.muslim.prayer.utils

const val PHONE_MASK = "+7 [000] [000] [00] [00]"
const val PHONE_MASK_FOR_EDIT_TEXT = "[000] [000] [0000]"
const val BIRTHDATE_MASK = "[00]{.}[00]{.}[9900]"
const val PHONE_MASK_REGEX = "^(\\d{3}[- .]?){2}\\d{4}$"
const val PHONE = "PHONE"
const val FORGOT = "FORGOT"
const val CHANGE_PHONE = "CHANGE_PHONE"
const val REQUEST_KEY = "REQUEST_KEY"
const val REQUEST_KEY_ROOT = "REQUEST_KEY_ROOT"
const val REFRESH = "REFRESH"
const val CARD_ITEM = "CARD_ITEM"
const val ORDER_REQUESTS = "ORDER_REQUESTS"
const val ORDER_REQUEST = "ORDER_REQUEST"
const val ORDER_ID = "ORDER_ID"
const val CARDS = "CARDS"
const val SERVICE_ITEM = "SERVICE_ITEM"
const val SERVICE_LIST = "SERVICE_LIST"
const val TYPE = "TYPE"
const val DOES_HAVE_ACTIVE_CARD = "DOES_HAVE_ACTIVE_CARD"
const val ADDRESS = "ADDRESS"
const val NEWS_ITEM = "NEWS_ITEM"
const val ITEMS = "ITEMS"
const val TITLE = "TITLE"
const val CREDENTIALS_HEADER = "Authorization"
const val SUCCESS_LINK = "litro.kz/success"
const val URL = "URL"
const val FAIL_LINK = "litro.kz/failed"
const val GENDER = "^((\\+7)+ (([0-9]){3})+ (([0-9]){3}))+ (([0-9]){2})+ (([0-9]){2})\$"
const val SHOW_BRIEF_DESCRIPTION = -1
const val STATUS_PUSH_ENABLED = 1
const val STATUS_PUSH_DISABLED = 0
const val NEW_BOUGHT_CARD = -1
const val ADD_NEW_CARD = -1
const val STATIC = Integer.MAX_VALUE
const val NOT_SELECTED = -1
const val NOT_LOADED = -1
const val HEADER = Integer.MIN_VALUE
const val SIMPLE = Integer.MAX_VALUE
const val LOADED = 1
const val PUSH_TYPE = "type"
const val OPEN_GIFT_CARDS = "OPEN_GIFT_CARDS"
const val PUSH_TYPE_ITEM_ID = "id"
const val SERVICES_WITH_CARD = -100
const val NEW_CARD_SERVICE = 0
const val BACKGROUND_MAIN = 0
const val BACKGROUND_BLACK = 1
const val BACKGROUND_GRAY = 2
const val ONESIGNAL_APP_ID = "84cd05f0-7fdf-4980-8e3e-074017a199d0"
const val SHOW_INFO_CURRENT_CARD = 1
const val FROM_SERVICE = "FROM_SERVICE"
const val TABLE_USER_ATTRIBUTE_DATA = "data"

enum class AutoNumberRegex(val value: String) {
    FIRST("^[0-9]{3}[A-Z]{2,3}[0-9]{2}$"),
    SECOND("^[A-Z]{1}[0-9]{3}[A-Z]{2,3}$"),
    THIRD("^[A-Z]{1}[0-9]{6}$")
}

const val INSURANCE_SUM_MASK = "[000] [000] [000] 〒"
