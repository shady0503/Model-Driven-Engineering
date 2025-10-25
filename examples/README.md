# Example YAML Configurations

This directory contains three diverse example YAML configurations demonstrating different domain models and features of the MDE Backend Generator.

**⚠️ IMPORTANT**: All examples use only features **currently supported** by the MDE metamodel. See [supported features](#supported-features) section below.

## Examples Overview

### 1. Healthcare System (`healthcare-system.yaml`)

**Domain**: Medical practice management  
**Database**: PostgreSQL  
**Complexity**: Medium - Complex medical workflows

**Entities (6)**:
- `MedicalSpecialties` - Medical specializations lookup table
- `Doctors` - Physician information with specialty
- `Patients` - Patient demographics and contact info
- `Appointments` - Scheduled doctor-patient appointments
- `MedicalRecords` - Visit records with diagnosis and treatment
- `Prescriptions` - Medication prescriptions linked to records

**Key Features**:
- Date and timestamp handling (appointments, records using DATETIME)
- Multiple MANY_TO_ONE relationships (Patient→Doctor, Appointment→Patient/Doctor)
- Audit trail fields (followUpDate, recordDate)
- Boolean flags (isActive, requiresCertification)
- TEXT fields for clinical notes
- Cascading relationships (records→prescriptions with SET_NULL)

**Use Case**: Demonstrates medical domain modeling with regulatory requirements for data retention and audit trails.

---

### 2. Social Media Platform (`social-media-platform.yaml`)

**Domain**: Social networking application  
**Database**: PostgreSQL  
**Complexity**: High - Many-to-many relationships and self-references

**Entities (10)**:
- `Users` - User profiles with authentication
- `Posts` - User-generated content posts
- `Comments` - Nested comments on posts
- `Likes` - Like reactions on posts and comments
- `UserFollows` - Self-referencing follower/following relationships
- `Hashtags` - Trending hashtag lookup
- `PostHashtags` - Many-to-many post-hashtag associations
- `DirectMessages` - Private user-to-user messaging
- `Notifications` - User notification system

**Key Features**:
- UUID primary keys (modern distributed systems)
- Self-referencing relationships (Users→Users for follows, Comments→Comments for threads)
- Many-to-many through join tables (Posts↔Hashtags via post_hashtags)
- Counters for denormalized data (followerCount, likeCount)
- Boolean flags (isVerified, isPrivate, isRead)
- STRING fields with length for URLs (profileImage, coverImage, mediaUrl)
- Nested comments (parent_comment_id)

**Use Case**: Demonstrates social platform architecture with viral content, user engagement metrics, and real-time interactions.

---

### 3. Financial Trading Platform (`financial-trading-platform.yaml`)

**Domain**: Stock/securities trading  
**Database**: PostgreSQL  
**Complexity**: High - Precise decimals and complex calculations

**Entities (9)**:
- `AccountTypes` - Account tier definitions
- `TradingAccounts` - Customer trading accounts
- `Securities` - Stocks, bonds, ETFs
- `TradeOrders` - Buy/sell order management
- `TradeExecutions` - Actual trade fills
- `PortfolioHoldings` - Current position tracking
- `AccountTransactions` - Deposits/withdrawals/dividends
- `PriceHistory` - Historical OHLC price data

**Key Features**:
- DECIMAL types for precise financial calculations (prices, amounts)
- **NOTE**: DECIMAL type uses default BigDecimal precision (no precision/scale config in metamodel)
- Financial audit trail (executedAt, placedAt, processedAt using DATETIME)
- STRING fields for enum-like values (orderType, side, status, timeInForce)
- LONG for large numbers (volume, marketCap)
- Calculated fields tracked in database (unrealizedGainLoss, averageFillPrice)
- Complex relationships (Order→Executions, Account→Holdings)

**Use Case**: Demonstrates financial systems with regulatory precision requirements, audit trails, and complex calculations.

---

## Supported Features

### Currently Supported Data Types
- **STRING** - String/varchar fields (use `length:` attribute)
- **INTEGER** - Integer numbers
- **LONG** - Long numbers (use instead of BIGINT)
- **BOOLEAN** - True/false values
- **DATE** - Date only (no time component)
- **DATETIME** - Date with time (use instead of TIMESTAMP)
- **TEXT** - Large text fields
- **UUID** - Universally unique identifier
- **DECIMAL** - Decimal numbers (no precision/scale attributes supported yet)

### Column Attributes
- `name:` - Column name (required)
- `type:` - DataType enum value (required)
- `primary:` - Boolean (true/false)
- `unique:` - Boolean (true/false)
- `nullable:` - Boolean (true/false)
- `length:` - Integer (for STRING/TEXT types only)

### Relationship Types
- **ONE_TO_MANY** - One-to-many relationship
- **MANY_TO_ONE** - Many-to-one relationship
- **ONE_TO_ONE** - One-to-one relationship
- **MANY_TO_MANY** - Many-to-many (through join table)

### Cascade Types
- **CASCADE** - Delete cascades
- **SET_NULL** - Set to null on delete
- **RESTRICT** - Prevent deletion if referenced

### Database Support
- ✅ **POSTGRESQL** - Fully supported
- ❌ **MySQL** - Not yet supported
- ❌ **MongoDB** - Not yet supported

### Language & Framework
- ✅ **JAVA** only
- ✅ **SPRING_BOOT** only

---

## Feature Comparison Matrix

| Feature | Healthcare | Social Media | Financial |
|---------|-----------|--------------|-----------|
| **Database** | PostgreSQL | PostgreSQL | PostgreSQL |
| **Primary Keys** | Auto-increment | UUID | Auto-increment |
| **Decimal Precision** | No | No | **Yes (18,8)** |
| **Self-Referencing** | No | **Yes (follows, comments)** | No |
| **Many-to-Many** | No | **Yes (post-hashtags)** | No |
| **Timestamps** | Medium usage | High usage | **Extensive** |
| **Audit Fields** | Medical records | Edit history | **Full audit trail** |
| **Text Fields** | Clinical notes | Posts/comments/bio | Limited |
| **Enums via VARCHAR** | Limited | Medium | **Extensive** |
| **Boolean Flags** | Some | Many | Some |
| **URL Fields** | No | **Yes (images/media)** | No |
| **Counters** | No | **Yes (likes, followers)** | No |
| **Calculated Fields** | No | No | **Yes (gains, averages)** |

---

## Data Type Coverage

| DataType | Healthcare | Social Media | Financial |
|----------|-----------|--------------|-----------|
| VARCHAR | ✓ | ✓ | ✓ |
| TEXT | ✓ | ✓ | Limited |
| INTEGER | ✓ | ✓ | ✓ |
| BIGINT | - | - | ✓ |
| DECIMAL | - | - | **✓ (primary)** |
| **Note** | | | **No precision/scale** |
| BOOLEAN | ✓ | ✓ | ✓ |
| DATE | ✓ | ✓ | ✓ |
| DATETIME | ✓ | ✓ | ✓ |
| UUID | - | **✓ (primary)** | - |

---

## Relationship Patterns

**Note**: All examples currently use **PostgreSQL** as the database. MySQL and MongoDB support is planned for future releases.

### Healthcare System
```
MedicalSpecialties ←──┐
                       │
Doctors ───────────────┘
  ↓
  ├── Appointments ←── Patients
  │        ↓
  └── MedicalRecords ←─┘
           ↓
      Prescriptions
```

### Social Media Platform
```
Users ←──┐
  ↓      │
  ├── Posts ──→ PostHashtags ──→ Hashtags
  │      ↓
  ├── Comments ──→ (self-reference)
  │      ↓
  ├── Likes
  │
  ├── UserFollows ──→ (self-reference)
  │
  ├── DirectMessages ──→ (self-reference)
  │
  └── Notifications
```

### Financial Trading Platform
```
AccountTypes
     ↓
TradingAccounts ───┬── TradeOrders ──→ TradeExecutions
                   │        ↓
                   │   Securities ←─┐
                   │        ↓        │
                   ├── PortfolioHoldings
                   │        
                   ├── AccountTransactions
                   │
                   └── PriceHistory ─┘
```

---

## Testing Each Example

### Generate Healthcare Project
```bash
.\mvnw.cmd exec:java "-Dexec.mainClass=com.mde.generator.CodeGenerator" \
  "-Dexec.args=examples/healthcare-system.yaml generated/healthcare-api"
```

### Generate Social Media Project
```bash
.\mvnw.cmd exec:java "-Dexec.mainClass=com.mde.generator.CodeGenerator" \
  "-Dexec.args=examples/social-media-platform.yaml generated/social-network-api"
```

### Generate Financial Trading Project
```bash
.\mvnw.cmd exec:java "-Dexec.mainClass=com.mde.generator.CodeGenerator" \
  "-Dexec.args=examples/financial-trading-platform.yaml generated/trading-platform-api"
```

---

## Recommended Learning Path

1. **Start with Healthcare** - Medium complexity, straightforward relationships
2. **Move to Social Media** - Learn UUIDs, self-references, many-to-many
3. **Advance to Financial** - Master precision types, complex calculations, audit trails

---

## Common Patterns Across Examples

### Audit Fields (All Examples)
- Automatic `createdAt` and `updatedAt` timestamps
- JPA auditing with `@CreatedDate` and `@LastModifiedDate`

### Naming Conventions
- Table names: `snake_case` (e.g., `medical_records`)
- Class names: `PascalCase` (e.g., `MedicalRecords`)
- Field names: `camelCase` (e.g., `createdAt`)

### Relationship Patterns
- Foreign keys: `{entity}_id` (e.g., `patient_id`)
- Join columns use `@JoinColumn(name = "...")`
- Inverse relationships use `@OneToMany(mappedBy = "...")`

### Default Values
- Boolean flags default to `false`
- Counters default to `0`
- Status fields use VARCHAR with default string values

---

## Extending These Examples

### Add a New Entity
1. Define entity under `entities:` section
2. Specify table name and fields
3. Add relationships to existing entities
4. Regenerate project

### Modify Field Types
1. Change `type:` attribute (STRING, INTEGER, LONG, BOOLEAN, DATE, DATETIME, TEXT, UUID, DECIMAL)
2. For STRING/TEXT, specify `length:`
3. **Note**: DECIMAL does not support `precision:` or `scale:` attributes

### Add Constraints
```yaml
# Use direct boolean attributes:
- name: email
  type: STRING
  length: 100
  nullable: false
  unique: true
```

### Configure Relationships
```yaml
# Add foreign key column with relation
- name: author_id
  type: UUID  # or INTEGER
  nullable: false
  relation:
    targetTable: users
    targetColumn: id
    type: MANY_TO_ONE
    onDelete: CASCADE  # or SET_NULL, RESTRICT
```

---

## Additional Resources

- **Metamodel**: `model/MDE.ecore` - Complete schema definition
- **Templates**: `templates/` - EGL code generation templates
- **Documentation**: `readme.md` - Full project documentation
